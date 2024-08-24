package analizadorlexico;

import Excepciones.ExcepcionLexica;
import sourcemanager.SourceManager;
import utils.Punctuation;

import java.io.IOException;
import java.lang.String;

import java.util.HashMap;

public class AnalizadorLexico {

    private String lexema;
    private char caracterActual;

    private SourceManager sourceManager;
    private static final HashMap<String, String> keywords = new HashMap<>();

    static {
        keywords.put("if", "pr_if");
        keywords.put("class", "pr_class");
        keywords.put("boolean", "pr_boolean");
        keywords.put("switch", "pr_switch");
        keywords.put("case", "pr_case");
        keywords.put("this", "pr_this");
        keywords.put("extends", "pr_extends");
        keywords.put("char", "pr_char");
        keywords.put("break", "pr_break");
        keywords.put("else", "pr_else");
        keywords.put("int", "pr_int");
        keywords.put("return", "pr_return");
        keywords.put("void", "pr_void");
        keywords.put("while", "pr_while");
        keywords.put("new", "pr_new");
        keywords.put("true", "pr_true");
        keywords.put("false", "pr_false");
        keywords.put("null", "pr_null");
        keywords.put("public", "pr_public");
        keywords.put("var", "pr_var");
        keywords.put("static", "pr_static");
    }
    
    public AnalizadorLexico(SourceManager sourceManager) {
        this.sourceManager = sourceManager;
        actualizarCaracterActual();
    }

    private void actualizarCaracterActual(){
        try {
            caracterActual = sourceManager.getNextChar();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Token proximoToken() throws ExcepcionLexica {
        lexema = " ";
        return estadoInicial();
    }

    private void actualizarLexema(){
        lexema = lexema + caracterActual;
    }

    private Token esLetra() {

        return null;
    }

    private Token esDigito() {
        return null;

    }

    private Token estadoInicial() throws ExcepcionLexica {
        if (Character.isDigit(caracterActual)) {
            actualizarLexema();
            actualizarCaracterActual();
            return esDigito();
        }else if(Character.isLetter(caracterActual)){
            actualizarLexema();
            actualizarCaracterActual();
            return esLetra();
        }  else if(Punctuation.isPunctuation(caracterActual)){
            actualizarLexema();
            actualizarCaracterActual();
            return esPuntuacion();
        } else if (sourceManager.END_OF_FILE == caracterActual) {
            return esEOF();
        } else if (Character.isWhitespace(caracterActual)) {
            actualizarCaracterActual();
            return estadoInicial();
        } else {
            actualizarLexema();
            throw new ExcepcionLexica(lexema,sourceManager.getLineNumber());
        }

    }

    private Token esEOF() {
        return null;
    }

    private Token esPuntuacion() {
        return null;
    }


}
