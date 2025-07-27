#include <stdio.h>
#include <string.h>
int main(int argc, char** argv)
{
	char str[100];
	int len,i;
	
	printf("masukan kalimat :");
	fgets(str, sizeof(str),stdin);
	len= strlen(str);
	for(i=strlen(str); i>=0;i--){
		printf("%c", str[i]);
	}
	printf("\n");
	return 0;
}