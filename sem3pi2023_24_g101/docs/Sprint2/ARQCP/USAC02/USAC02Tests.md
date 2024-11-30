# Testes unitários para a USAC02

Neste ficheiro, vamos visualizar os testes realizados para a funcionalidade pedida na USAC02, analizando cada método utilizado para os testes.

**Aqui, vemos os casos testados:**

```java
void test_One(){
    run_test((int[]){0,0,0},3,0,0,5,(int[]){5,0,0},0,1);
}

void test_Zero(){
    run_test((int[]){0,0,0},3,0,2,5,(int[]){0,0,5},1,0);
}

void test_Three(){
    run_test((int[]){0,0,0,0},4,3,3,5,(int[]){0,0,0,5},3,0);
}

void test_Five(){
    run_test((int[]){0,0,0,0},4,0,3,5,(int[]){0,0,0,5},1,0);
}

```
Nestes métodos, vemos casos diferentes a serem enviados para o seguinte método.

```java
void run_test(int * array, int len, int rd, int wr, int val,
        int * exp_arr, int exp_rd, int exp_wr)
        {
        int vec[100];
        // 0 - sentinel                                                         
        // 1 - read                                                             
        // 2 - sentinel                                                         
        // 3 - write                                                            
        // 4 - sentinel                                                             
        // 5 - buffer                                                           
        // 5+length - sentinel                                                  


        memcpy(vec+5,array,len*sizeof(int));  // buffer                         
        vec[1]=rd;
        vec[3]=wr;

        call_func(enqueue_value,vec+5,len,vec+1,vec+3,val);

        TEST_ASSERT_EQUAL_INT(0x55555555,vec[0]);    // check sentinel             
        TEST_ASSERT_EQUAL_INT(0x55555555,vec[2]);    // check sentinel             
        TEST_ASSERT_EQUAL_INT(0x55555555,vec[4]);    // check sentinel             
        TEST_ASSERT_EQUAL_INT(0x55555555,vec[len+5]);    // check sentinel         
        TEST_ASSERT_EQUAL_INT_ARRAY(exp_arr,vec+5,len);    // check buffer        
        TEST_ASSERT_EQUAL_INT(exp_rd,vec[1]);    // check read                     
        TEST_ASSERT_EQUAL_INT(exp_wr,vec[3]);    // check write  
}
```
**Nota:** Este método recebe o *array*, o seu tamanho, os apontadores read,e write respetivamente o valor a inserir como parâmetro(Ex: No *test_One*, é enviado um array com os elementos 0, 0 e 0, tamanho 3,apontadores read = 0, write = 3 valor = 5 e os o array e apontadores esperados são:
 0  0  5   , read = 1 , write = 0).

**Nota 2:** Todas estas variáveis têm como tipo inteiro(int).