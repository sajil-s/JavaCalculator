#include<jni.h>
#include "Backend.h"



JNIEXPORT jint JNICALL Java_Backend_calculate(JNIEnv *env, jobject obj, jint a, jint b, jchar op) {
    switch (op)
    {
    case '+':
        return a + b;
    case '-':
        return a - b;
    case '*':
        return a * b;
    case '/':
        return a / b;
    }
}

