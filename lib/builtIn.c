#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print(char* str) {
    printf("%s", str);
}

void println(char* str) {
    printf("%s\n", str);
}

void printInt(int n) {
    printf("%d", n);
}

void printlnInt(int n) {
    printf("%d\n", n);
}

char* getString() {
    char* buffer = (char*)malloc(sizeof(char) * 257);
    scanf("%s", buffer);
    return buffer;
}

int getInt() {
    int n;
    scanf("%d", &n);
    return n;
}

char* toString(int i) {
    if (i == 0) {
        char* res = (char*)malloc(sizeof(char) * 2);
        res[0] = '0';
        res[1] = '\0';
        return res;
    }

    char s[10];
    char neg, len = 0;
    if (i > 0)
        neg = 0;
    else {
        neg = 1;
        i = -i;
    }
    while (i > 0) {
        s[len++] = i % 10;
        i /= 10;
    }

    char* res = (char*)malloc(sizeof(char) * (neg + len + 1));
    if (neg > 0)
        res[0] = '-';
    char p = 0;
    while (p < len) {
        res[p + neg] = s[len - p - 1] + '0';
        p++;
    }
    res[len + neg] = '\0';
    return res;
}

char* _bot_str_cat(char* str1, char* str2) {
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    char* res = (char*)malloc(sizeof(char) * (len1 + len2 + 1));
    strcat(res, str1);
    strcat(res, str2);
    return res;
}

char _bot_str_eq(char* str1, char* str2) {
    return strcmp(str1, str2) == 0;
}

char _bot_str_neq(char* str1, char* str2) {
    return strcmp(str1, str2) != 0;
}

char _bot_str_slt(char* str1, char* str2) {
    return strcmp(str1, str2) < 0;
}

char _bot_str_sgt(char* str1, char* str2) {
    return strcmp(str1, str2) > 0;
}

char _bot_str_sle(char* str1, char* str2) {
    return strcmp(str1, str2) <= 0;
}

char _bot_str_sge(char* str1, char* str2) {
    return strcmp(str1, str2) >= 0;
}

int _str_length(char* str) {
    return strlen(str);
}

char* __str_substring(char* str, int left, int right) {
    int len = right - left;
    char* res = (char*)malloc(sizeof(char) * (len + 1));
    int p = 0;
    while (p < len) {
        res[p] = str[left + p];
        p++;
    }
    res[len] = '\0';
    return res;
}

int _str_parseInt(char* str) {
    int res = 0, p = 0;
    while (str[p] != '\0' && str[p] >= '0' && str[p] <= '9')
        res = res * 10 + str[p++] - '0';
    return res;
}

int __str_ord(char* str, int pos) {
    return str[pos];
}

int _array_size(char* arr) {
    return *(((int*)arr) - 1);
}