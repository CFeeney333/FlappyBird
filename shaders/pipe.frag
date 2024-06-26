#version 330 core

layout (location=0) out vec4 color;

in DATA
{
    vec2 tc;
    vec3 position;
} fs_in;

uniform sampler2D tex;
uniform int top;
uniform vec2 bird;


void main() {
    if (top == 1)
    {
        vec2 new_tc = vec2(fs_in.tc.x, 1.0 - fs_in.tc.y);
        color = texture(tex, new_tc);
    }
    else {
        color = texture(tex, fs_in.tc);
    }
    color *= 2.0 / (length(bird - fs_in.position.xy) + 2.5) + 0.6;
    color.w = 1.0;


    if (color.w < 1.0)
        discard;
}