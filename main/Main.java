package main;

import Excepciones.ExcepcionLexica;
import analizadorlexico.AnalizadorLexico;
import analizadorlexico.Token;
import sourcemanager.SourceManager;
import sourcemanager.SourceManagerImpl;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <source_file>");
            return;
        }

        String sourceFile = args[0];
        SourceManager sourceManager = new SourceManagerImpl();
        AnalizadorLexico lexer = new AnalizadorLexico(sourceManager);

        try {
            sourceManager.open(sourceFile);

            Token token;
            while ((token = lexer.proximoToken()) != null) {
                System.out.println("Token Name: " + token.getId());
                System.out.println("Lexeme: " + token.getLexema());
                System.out.println("Line Number: " + token.getLineNumber());
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (ExcepcionLexica e) {
            System.out.println("ERROR!");
            //System.out.println("Lexeme: " + e.getLexema());
            //System.out.println("Line: " + e.getLineNumber());
            System.out.println("Message: " + e.getMessage());
        } finally {
            try {
                sourceManager.close();
            } catch (IOException e) {
                System.out.println("Error closing file reader: " + e.getMessage());
            }
        }
    }
}
