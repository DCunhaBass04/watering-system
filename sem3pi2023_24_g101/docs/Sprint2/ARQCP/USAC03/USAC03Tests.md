# Testes unitários para a USAC03

Neste ficheiro, vamos visualizar os testes realizados para a funcionalidade pedida na USAC03, analizando cada método utilizado para os testes.

**Aqui, vemos os casos testados:**

```java
void test_One()
{
    run_test((int[]){0,0,0},3,0,0,1,0,(int[]){0,0,0},0,0);
}
void test_Zero()
{
    run_test((int[]){1,0,0},3,0,1,1,1,(int[]){1},1,1);
}
void test_Three()
{
    run_test((int[]){1,2,3,4},4,3,2,3,1,(int[]){4,1,2},2,2);
}
void test_Five()
{
    run_test((int[]){1,2,3,4},4,2,1,3,1,(int[]){3,4,1},1,1);
}

```
Nestes métodos, vemos casos diferentes a serem enviados para o seguinte método.

```java
void run_test(int * array, int len, int rd, int wr, int num,
        int exp_res, int * exp_vec, int exp_rd, int exp_wr)
        {
        int v1[100];
        // 0 - sentinel  
        // 1 - read 
        // 2 - sentinel  
        // 3 - write 
        // 4 - sentinel 
        // 5 - buffer 
        // 5+length - sentinel 	

        // setup 
        memset(v1, 0x55, sizeof v1);
        memcpy(v1+5,array,len*sizeof(int));  // buffer   
        v1[1]=rd;
        v1[3]=wr;

        int v2[100];
        memset(v2, 0x55, sizeof v2);    // destination 
        int res;
        res=call_func(move_num_vec, v1+5, len, v1+1, v1+3, num, v2+1);
        TEST_ASSERT_EQUAL_INT(exp_res,res);    // check result 
        TEST_ASSERT_EQUAL_INT(0x55555555, v1[0]);    // check sentinel 
        TEST_ASSERT_EQUAL_INT(0x55555555, v1[2]);    // check sentinel  
        TEST_ASSERT_EQUAL_INT(0x55555555, v1[4]);    // check sentinel  
        TEST_ASSERT_EQUAL_INT(0x55555555, v1[len+5]);    // check sentinel  
        TEST_ASSERT_EQUAL_INT_ARRAY(array, v1+5, len);    // check buffer 
        TEST_ASSERT_EQUAL_INT(exp_rd, v1[1]);    // check read   
        TEST_ASSERT_EQUAL_INT(exp_wr, v1[3]);    // check write  
        // output vector  
        TEST_ASSERT_EQUAL_INT(0x55555555, v2[0]);    // check sentinel 
        TEST_ASSERT_EQUAL_INT(0x55555555, v2[num+1]);    // check sentinel  
        if (exp_res==1)
        TEST_ASSERT_EQUAL_INT_ARRAY(exp_vec,v2+1, num);
        // check output
        else
        TEST_ASSERT_EQUAL_INT(0x55555555, v2[1]);    // check output 
}
```
**Nota:** Este método recebe o *array*, o seu tamanho, os apontadores read,e write respetivamente o valor a inserir como parâmetro(Ex: No *test_One*, é enviado um array com os elementos 0, 0 e 0, tamanho 3,apontadores read = 0, write = 3 valor = 5 e os o array e apontadores esperados são:
0  0  5   , read = 1 , write = 0).

**Nota 2:** Todas estas variáveis têm como tipo inteiro(int).