package Gals;

public interface ParserConstants
{
    int START_SYMBOL = 35;

    int FIRST_NON_TERMINAL    = 35;
    int FIRST_SEMANTIC_ACTION = 62;

    int[][] PARSER_TABLE =
    {
        { -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1,  0, -1, -1,  0, -1,  0,  0 },
        { -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  1, -1, -1, -1,  1, -1, -1,  1, -1,  1,  1 },
        { -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1, -1, -1,  7, -1, -1,  5, -1,  6,  6 },
        { -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, 14 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 15, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 24, 24, 24, 24, 24, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, 24, -1, -1, 24, -1, -1, -1, -1, 24, -1, 24, -1, -1, 24, -1, -1 },
        { -1, 27, 27, 27, 27, 27, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, 27, -1, -1, -1, -1, 27, -1, 27, -1, -1, 27, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 28, 28, -1, 28, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1 },
        { -1, 31, 31, 31, 31, 31, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, 31, -1, -1, -1, -1, 33, -1, 34, -1, -1, 32, -1, -1 },
        { -1, 35, 35, 35, 35, 35, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 36, 36, -1, 36, -1, 36, 37, 37, 37, 37, 37, 37, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, 39, 40, 41, 42, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 44, 44, 44, 44, 44, -1, -1, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, 44, -1, -1, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 45, 45, -1, 45, -1, 45, 45, 45, 45, 45, 45, 45, 47, -1, -1, 46, 45, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1 },
        { -1, 48, 48, 48, 48, 48, -1, -1, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, 48, -1, -1, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 49, 49, -1, 49, -1, 49, 49, 49, 49, 49, 49, 49, 49, 50, 51, 49, 49, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1 },
        { -1, 52, 53, 54, 55, 56, -1, -1, -1, -1, 57, -1, -1, -1, -1, -1, -1, -1, 59, -1, -1, 58, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        {  2,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  3,  2,  2, -1,  3, -1, -1,  3, -1,  3,  3 },
        { -1, -1, -1, -1, -1, -1, -1, 10, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, 16, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, 19, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 23, -1, 22, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS = 
    {
        { 77, 83, 36, 78 },
        { 37,  8, 56 },
        {  0 },
        { 36 },
        { 38 },
        { 39 },
        { 40 },
        { 41 },
        { 42 },
        { 43,  9, 45, 57 },
        { 86 },
        { 87, 10, 28, 45, 88 },
        { 31, 11, 43, 89, 12 },
        { 33, 11, 44, 12 },
        { 34, 11, 44, 12, 79 },
        { 28, 11, 45, 12, 90, 36, 58, 91 },
        { 26 },
        { 92, 25, 36, 26 },
        { 24, 93, 11, 45, 12, 10, 28, 59 },
        { 32, 94, 36, 26, 95 },
        { 27, 94, 36, 26, 95 },
        {  2, 84, 60 },
        {  0 },
        {  7, 43 },
        { 45, 76, 61 },
        {  0 },
        {  7, 44 },
        { 47, 46 },
        {  0 },
        { 23, 47, 80, 46 },
        { 30, 47, 81, 46 },
        { 48 },
        { 32, 73 },
        { 27, 74 },
        { 29, 47, 75 },
        { 51, 49 },
        {  0 },
        { 50, 71, 51, 72 },
        { 13 },
        { 14 },
        { 15 },
        { 16 },
        { 17 },
        { 18 },
        { 53, 52 },
        {  0 },
        { 22, 53, 63, 52 },
        { 19, 53, 64, 52 },
        { 55, 54 },
        {  0 },
        { 20, 55, 65, 54 },
        { 21, 55, 66, 54 },
        {  2, 85 },
        {  3, 67 },
        {  4, 68 },
        {  5 },
        {  6, 82 },
        { 11, 45, 12 },
        { 22, 55 },
        { 19, 55, 70 }
    };
    
    
    String[] PARSER_ERROR =
    {
    "",
    "esperado EOF",
    "esperado identificador", //cIdentificador
    "esperado contante_int",// cFloat
    "esperado contante_float",// cFloat
    "esperado contante_bin",// cBin
    "esperado contante_string",// cString
    "esperado \",\"",// \",\""
    "esperado \";\"",// \";\""
    "esperado \"=\"",//  \"=\""
    "esperado \":\"",// \":\""
    "esperado \"(\"",// \"(\""
    "esperado \")\"",// \")\""
    "esperado \"==\"",// \"==\""
    "esperado \"!=\"",// \"!=\""
    "esperado \"<\"",// \"<\""
    "esperado \"<=\"",// \"<=\""
    "esperado \">\"",// \">\""
    "esperado \">=\"",// \">=\""
    "esperado \"-\"",// \"-\""
    "esperado \"*\"",// \"*\""
    "esperado \"/\"",// \"/\""
    "esperado \"+\"",// \"+\""
    "esperado and",//and 
    "esperado check",//check
    "esperado else",//else
    "esperado end",//end
    "esperado false",//false
    "esperado if",//if
    "esperado not",//not
    "esperado or",//or
    "esperado read",//read
    "esperado true",//true
    "esperado write",//write
    "esperado writeln",//writeln
    "esperado identificador check if read write writeln",//programa
    "esperado identificador check if read write writeln",//lista_de_comandos
    "esperado identificador check if read write writeln",//comando
    "esperado identificador",//c_atribuicao
    "esperado read",//c_entrada_dado
    "esperado write writeln",//c_saida_dado
    "esperado if",//c_selecao
    "esperado check",//c_repeticao
    "esperado identificador",//lista_identificadores
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ( - + false not true" ,//lista_expressoes
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ( - + false not true",//expressao
    "esperado , ; : ) and or",//expressao_
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ( - + false not true",//elemento
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ( - +",//relacional
    "esperado , ; : ) == != < <= > >= and or",//relacional_
    "esperado == != < <= > >=",//operador_relacional
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ( - +",//aritmetica
    "esperado , ; : ) == != < <= > >= - + and or",//aritmetica_
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ( - +",//termo
    "esperado , ; : ) == != < <= > >= - * / + and or",//termo_
    "esperado identificador constanteInt constanteFloat constanteBinaria constanteString ) - +",//fator
    "esperado EOF identificador check else end if read write writeln",//lista_de_comandos1
    "esperado ; :",//c_atribuicao1
    "esperado else end",//c_selecao
    "esperado false true",//c_repeticao1
    "esperado , = )",//lista_identificadores1
    "esperado , )"//lista_expressoes1
    };
}
