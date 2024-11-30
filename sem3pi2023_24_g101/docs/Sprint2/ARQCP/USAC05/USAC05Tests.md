# Testes unitários para a USAC05

Neste ficheiro, vamos visualizar os testes que foram realizados para a funcionalidade pedida na USAC05, analizando cada método utilizado para os testes.

Aqui, vemos os casos testados.

```java
void test_NullVector()
{ 
    run_test((int[]){0},0,0); 
}
void test_One()
{ 
    run_test((int[]){1000},1,1000); 
}
void test_Zero()
{ 
    run_test((int[]){10,0,1},3,1); 
}
void test_Three()
{ 
    run_test((int[]){-1,-3,-2},3,-2); 
}
void test_Four()
{ 
    run_test((int[]){-1,-3,-4,-2},4,-2); 
}
void test_Five()
{ 
    run_test((int[]){1,1,1,1,2},5,1); 
}
```
Em todos estes métodos, vemos casos diferentes a serem enviados para o seguinte método.

```java
void run_test(int * vec, int in_num, int  exp_med)
{
    int vec1[100];

	int res; 


    // setup 
        memset(vec1, 0x55, sizeof vec1);
     
	memcpy(vec1+1,vec,in_num*sizeof(int));  //   
	res=call_func(mediana,vec1+1,in_num);
    
    TEST_ASSERT_EQUAL_INT(0x55555555, vec1[in_num+1]);    // check sentinel 
    TEST_ASSERT_EQUAL_INT(0x55555555, vec1[0]);    // check sentinel  
    TEST_ASSERT_EQUAL_INT(exp_med, res);    // check vec 
    
}
```
**Nota:** Este método recebe o *array*, o seu tamanho, e a mediana esperada como parâmetros (Ex.: No *test_Three*, é enviado um array com os elementos -1, -3 e -2, tamanho 3, e a mediana esperada é -2).