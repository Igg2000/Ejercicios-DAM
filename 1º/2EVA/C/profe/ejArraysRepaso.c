#include <stdio.h>

int main(int argc, char *argv[]) {
	
	
	int num[3]		={23,34,7};
	int puntos[3]	={4,12,6};
	char *nom[3] 	={"Ana","Juan","Dani"};
	int i,mayor;
	
	for(i=0;i<3;i++)
		printf("El jug num %d (%s) ha anotado %d puntos\n",num[i],nom[i],puntos[i]);
	
	mayor=0;
	for(i=1;i<3;i++)
		if(puntos[i]>puntos[mayor])
			mayor=i;
	
	printf("El jug q ha anotado + puntos es %s con %d puntos\n",nom[mayor],puntos[mayor]);
	
	return 0;
}

