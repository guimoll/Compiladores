package Gals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants {

    private String operador = "";
    private final List<String> codigo = new ArrayList<>();
    public Stack pilhaTipos = new Stack();
    private final List<String> listaIdentificadores = new ArrayList<>();
    public Stack pilhaRotulos = new Stack();
    private Map<String, String> tabelaSimbolos = new HashMap<String,String>();
    private int numRotulo = 0;
    private String rotulo = "r";

    public void executeAction(int action, Token token) throws SemanticError {
        System.out.println("rotulos: "+ pilhaRotulos.toString());
        System.out.println("tipos: "+pilhaTipos.toString());
        System.out.println("Passou na ação semântica: " + action);
        switch (action) {
            case 1:
                acaoSemantica1();
                break;
            case 2:
                acaoSemantica2();
                break;
            case 3:
                acaoSemantica3();
                break;
            case 4:
                acaoSemantica4();
                break;
            case 5:
                acaoSemantica5(token);
                break;
            case 6:
                acaoSemantica6(token);
                break;
            case 7:
                acaoSemantica7();
                break;
            case 8:
                acaoSemantica8();
                break;
            case 9:
                acaoSemantica9(token);
                break;
            case 10:
                acaoSemantica10(token);
                break;
            case 11:
                acaoSemantica11();
                break;
            case 12:
                acaoSemantica12();
                break;
            case 13:
                acaoSemantica13();
                break;
            case 14:
                acaoSemantica14();
                break;
            case 15:
                acaoSemantica15();
                break;
            case 16:
                acaoSemantica16();
                break;
            case 17:
                acaoSemantica17();
                break;
            case 18:
                acaoSemantica18();
                break;
            case 19:
                acaoSemantica19();
                break;
            case 20:
                acaoSemantica20(token);
                break;
            case 21:
                acaoSemantica21();
                break;
            case 22:
                acaoSemantica22(token);
                break;
            case 23:
                acaoSemantica23(token);
                break;
            case 24:
                acaoSemantica24(token);
                break;
            case 25:
                acaoSemantica25(token);
                break;
            case 26:
                acaoSemantica26(token);
                break;
            case 27:
                acaoSemantica27(token);
                break;
            case 28:
                acaoSemantica28();
                break;
            case 29:
                acaoSemantica29();
                break;
            case 30:
                acaoSemantica30();
                break;
            case 31:
                acaoSemantica31();
                break;
            case 32:
                acaoSemantica32(token);
                break;
            case 33:
                acaoSemantica33();
                break;
        }
    }

    private void acaoSemantica1() {
        String tipo1 = pilhaTipos.pop().toString();
        String tipo2 = pilhaTipos.pop().toString();
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.add(" add \n ");
    }

    private void acaoSemantica2() {
        String tipo1 = pilhaTipos.pop().toString();
        String tipo2 = pilhaTipos.pop().toString();
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.add(" sub \n ");
    }

    private void acaoSemantica3() {
        String tipo1 = pilhaTipos.pop().toString();
        String tipo2 = pilhaTipos.pop().toString();
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.add(" mul \n ");
    }

    private void acaoSemantica4() {
        String tipo1 = pilhaTipos.pop().toString();
        String tipo2 = pilhaTipos.pop().toString();
        if (tipo1.equals("float64") || tipo2.equals("float64")) {
            pilhaTipos.push("float64");
        } else {
            pilhaTipos.push("int64");
        }
        codigo.add(" div \n ");
    }

    private void acaoSemantica5(Token token) {
        this.pilhaTipos.push("int64");
        String int64 = "";
        int64 = token.getLexeme().replace(".", "");
        codigo.add(" ldc.i8 " + int64 + " \n ");
        codigo.add(" conv.r8 \n");
    }

    private void acaoSemantica6(Token token) {
        this.pilhaTipos.push("float64");
        String float64 = "";
        float64 = token.getLexeme().replace(".", "");
        float64 = float64.replace(",", ".");
        codigo.add(" ldc.r8 " + float64 + " \n ");
    }

    private void acaoSemantica7() {
    }

    private void acaoSemantica8() {
        codigo.add(" ldc.i8 -1 \n ");
        codigo.add(" conv.r8 \n ");
        codigo.add(" mul \n ");
    }

    private void acaoSemantica9(Token token) {
        operador = token.getLexeme();
    }

    private void acaoSemantica10(Token token) {
        String tipo1 = pilhaTipos.pop().toString();
        String tipo2 = pilhaTipos.pop().toString();
        pilhaTipos.push("bool");

        switch (operador) {
            case ("!="):
                codigo.add(" ceq" + "\n" + "ldc.i4.0" + "\n" + "ceq \n ");
                break;
            case ("<="):
                codigo.add(" cgt \n ");
                codigo.add(" ldc.i4 0 \n ");
                codigo.add(" ceq \n ");
                break;
            case (">="):
                codigo.add(" clt \n ");
                codigo.add(" ldc.i4 0 \n ");
                codigo.add(" ceq \n ");
                break;
            case ("=="):
                codigo.add(" ceq \n ");
                break;
            case (">"):
                codigo.add(" cgt \n ");
                break;
            case ("<"):
                codigo.add(" clt \n ");
                break;
        }
    }

    private void acaoSemantica11() {
        pilhaTipos.push("bool");
        codigo.add(" ldc.i4.1 \n ");
    }

    private void acaoSemantica12() {
        pilhaTipos.add("bool");
        codigo.add(" ldc.i4.0 \n ");
    }

    private void acaoSemantica13() {
        codigo.add(" ldc.i4.1 \n ");
        codigo.add(" xor \n");
    }

    private void acaoSemantica14() {
        String tipo = pilhaTipos.pop().toString();
        if (tipo.equals("int64")) {
            codigo.add(" conv.i8 ");
        }
        codigo.add(" \n call void [mscorlib]System.Console::Write(" + tipo + ") \n ");
    }

    private void acaoSemantica15() {
        codigo.add(" .assembly extern mscorlib {} \n" + " .assembly _codigo_objeto{} \n" + " .module _codigo_objeto.exe \n" + " \n" + " .class public _UNICA{ \n" + " .method static public void _principal() { \n" + " .entrypoint \n \n");
    }

    private void acaoSemantica16() {
        codigo.add(" ret " + "} \n" + "} \n");
    }

    private void acaoSemantica17() {
        codigo.add(" ldstr  \"\\r\\n\" \n");

        codigo.add(" call void [mscorlib]System.Console::Write(string) \n");
    }

    private void acaoSemantica18() {
        String tipo1 = (String) pilhaTipos.pop();
        String tipo2 = (String) pilhaTipos.pop();
        pilhaTipos.push("bool");
        codigo.add(" and \n ");
    }

    private void acaoSemantica19() {
        String tipo1 = (String) pilhaTipos.pop();
        String tipo2 = (String) pilhaTipos.pop();
        //if (tipo1.equals("bool") || tipo2.equals("bool")) {
        pilhaTipos.push("bool");
        codigo.add(" or \n");
        //}
    }

    private void acaoSemantica20(Token token) {
        this.pilhaTipos.push("string");
        codigo.add(" ldstr " + token.getLexeme() + " \n");
    }

    private void acaoSemantica21() {
        codigo.add(
                " .locals(int64 _temp_int, float64 _temp_float, string _temp_str, bool _temp_bool) \n"
        );
    }

    private void acaoSemantica22(Token token) {
        listaIdentificadores.add(token.getLexeme());
    }

    private void acaoSemantica23(Token t) {
        if (tabelaSimbolos.containsKey(t.getLexeme())) { // a
            codigo.add(" ldloc " + t.getLexeme() + " \n ");
            String tipoIdentificador = tabelaSimbolos.get(t.getLexeme());
            if (tipoIdentificador.equals("int64")) {
                codigo.add(" conv.r8 \n ");
            }
            pilhaTipos.add(tipoIdentificador);
        } else {
            System.out.println("Identificador não declarado!,parar o programa");
        }
    }

    private void acaoSemantica24(Token token) {
            
        Object pilha2 = pilhaTipos.toArray();
        String tipo = pilhaTipos.pop().toString();
        for (int i = 0; i <  listaIdentificadores.size() - 1; i++) {
            codigo.add("dup \n");
        }
        for (String str : listaIdentificadores) {
           
            if (!tabelaSimbolos.containsKey(str)) {
                tabelaSimbolos.put(str, tipo);
                // chave = nome do identificador
                // valor = tipo do identificador

                codigo.add(".locals (" + tipo + " " + str + ") \n ");   

            } else {
                if (!verificarExpressao(tipo, str)) {
                    System.out.println("tipos incompatíveis em comando de atribuição)");
                }
                //parar a execução se cair aqui

            }
            if (tipo.equals("int64")) {
                codigo.add("conv.i8 \n");
            }
         
            codigo.add("stloc " + str +" \n ");
        }

        listaIdentificadores.clear();

    }

   private void acaoSemantica25(Token token) {
        String tipo = pilhaTipos.pop().toString();
        switch (tipo) {
            case "int64":
               codigo.add("conv.i8  \n");
                codigo.add(" stloc _temp_int   \n ");
                listaIdentificadores.add(token.getLexeme());
                pilhaTipos.push("int64");
                break;
            case "float64":
                codigo.add(" stloc _temp_float   \n");
                listaIdentificadores.add(token.getLexeme());
                pilhaTipos.push("float64");
                break;
            case "bool":
                codigo.add(" stloc _temp_bool \n ");
                listaIdentificadores.add(token.getLexeme());
                pilhaTipos.push("bool");
                break;
            case "string":
                codigo.add(" stloc _temp_str \n ");
                listaIdentificadores.add(token.getLexeme());
                pilhaTipos.push("string");
                break;
        }
    }

    
   private void acaoSemantica26(Token token) {
       pilhaTipos.pop();
       String tipo = pilhaTipos.pop().toString();
        String identificador = listaIdentificadores.remove(listaIdentificadores.size() - 1);

        codigo.add(" brfalse r \n ");

        for (int i = 0; i < listaIdentificadores.size(); i++) {
            if (listaIdentificadores.get(i).equals(identificador)) {
                listaIdentificadores.remove(i);
            }
        }
      switch (tipo) {
            case "int64":
                 codigo.add(" ldloc _temp_int \n ");
                break;
            case "float64":
                 codigo.add(" ldloc _temp_float  \n ");
                break;
            case "bool":
                 codigo.add(" ldloc _temp_bool \n ");
                break;
            case "string":
                 codigo.add(" ldloc _temp_str \n ");
                break;
        }
        

        for (int i = 0; i < listaIdentificadores.size() - 1; i++) {
            codigo.add(" dup \n ");
        }

        for (String str : listaIdentificadores) {
            if (!tabelaSimbolos.containsKey(str)) {
                switch (tipo) {
                    case "int64":
                        codigo.add(" .locals (int64 ".concat(str.concat("  ) \n ")));
                        tabelaSimbolos.put(str, tipo);
                        break;
                    case "float64":
                        codigo.add(" .locals (float64 ".concat(str.concat(" ) \n ")));
                        tabelaSimbolos.put(str, tipo);
                        break;
                    case "bool":
                        codigo.add(" .locals (bool ".concat(str.concat(" ) \n ")));
                        tabelaSimbolos.put(str, tipo);
                        break;
                    case "string":
                        codigo.add(" .locals (string ".concat(str.concat(" ) \n ")));
                        tabelaSimbolos.put(str, tipo);
                        break;
                }
            } else {
                if (!tipo.equals(tabelaSimbolos.get(str))) {
                    System.out.println("Tipos incompatíveis em comando de atribuição.");
                } 
           
            
            }
        
        codigo.add("stloc "+str+" \n");
        }
        listaIdentificadores.clear();
        codigo.add(this.rotulo.concat(": \n "));
    }
   
   
    public void acaoSemantica27(Token token) {
        for (String str : listaIdentificadores) {
            if (!tabelaSimbolos.containsKey(str)) {
                // parar a execução
                System.out.println(" identificador " + str + " não declarado");
            }
            String tipo = tabelaSimbolos.get(str);

            switch (tipo) {
                case "int64":

                    codigo.add(" call string [mscorlib]System.Console::ReadLine()  \n");
                    codigo.add(" call int64 [mscorlib]System.Int64::Parse(string)  \n");
                 //   codigo.add(" call void [mscorlib]System.Console::Write(int64) \n");
                    break;
                case "float64":
                    codigo.add(" call string [mscorlib]System.Console::ReadLine()  \n");
                    codigo.add(" call float64 [mscorlib]System.Double::Parse(string)  \n");
                 //   codigo.add(" call void [mscorlib]System.Console::Write(float64) \n");

                    break;
                case "string":
                    codigo.add(" call string [mscorlib]System.Console::ReadLine() \n ");
                 //   codigo.add(" call void [mscorlib]System.Console::Write(string) \n ");
                    break;
                case "bool":
                    codigo.add(" call string [mscorlib]System.Console::ReadLine()  \n");
                    codigo.add(" call bool [mscorlib]System.Boolean::Parse(string)  \n");
                   // codigo.add(" call void [mscorlib]System.Console::Write(bool) \n ");
                    
                    break;

            }
       codigo.add("stloc " +str+" \n ");
        }
       
        listaIdentificadores.clear();
    
    }

    private void acaoSemantica28() {
        String tipo = pilhaTipos.pop().toString();
        criarRotulo();
        codigo.add("brfalse "+this.rotulo+" \n");
        pilhaRotulos.push(this.rotulo);
    }

    private void acaoSemantica29() {
    String rotulo2 = (String) pilhaRotulos.pop();
        codigo.add(rotulo2+": \n");
    }

    private void acaoSemantica30() {
    
        criarRotulo();
        codigo.add("br  " + this.rotulo + "  \n");
        String rotulo1 = (String) pilhaRotulos.pop();
        codigo.add(rotulo1 + ":  \n");
        pilhaRotulos.push(this.rotulo);
    }

    private void acaoSemantica31() {
       
        criarRotulo();
        codigo.add(this.rotulo.concat(": \n "));
        pilhaRotulos.push(this.rotulo);
    }

    private void acaoSemantica32(Token token) {
        String asd = token.getLexeme();
        criarRotulo();
       // averiguar
        if(token.getLexeme().equals("true")){
            codigo.add("brfalse "+this.rotulo+" \n");
        } else  codigo.add("brtrue "+this.rotulo+" \n");
       
        pilhaRotulos.push(this.rotulo);
      
    }

    private void acaoSemantica33() {
        String rotulo1 = pilhaRotulos.pop().toString();
        String rotulo2 = pilhaRotulos.pop().toString();
        codigo.add(" br ".concat(rotulo2).concat(" \n "));
        codigo.add(rotulo1.concat(": \n "));
    }

    public List<String> getCodigo() {
        return codigo;
    }

    private boolean verificarExpressao(String tipo, String str) {
        boolean result = false;

        switch (str) {
            case "float64":
                if (tipo.equals("int64") || (tipo.equals("float64"))) {
                    result = true;
                }
                break;
            default:
                if (tipo.equals(tabelaSimbolos.get(str))) {
                    result = true;
                }
                break;
        }

        return result;

    }

    private void criarRotulo() {
        this.rotulo = this.rotulo + this.numRotulo + 1;
    }
}
