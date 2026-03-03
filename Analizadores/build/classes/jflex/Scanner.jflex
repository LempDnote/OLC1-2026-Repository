package analisis;

import java_cup.runtime.*;
import java.util.List;
import java.util.ArrayList;

%%

%class Lexer
%unicode
%cup
%line
%column
%public

%{

  private List<String> errors = new ArrayList<>();
  //FORMAR CADENAS PARA LOS STRING LITERAL
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

  public List<String> getErrors() {
    return errors;
  }

  public void setErrors(List<String> errors) {
    this.errors = errors;
  }
  
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t\f]


Comment = {ComentarioJDoc} | {ComentarioLinea} | {TraditionalComment}
ComentarioJDoc = "#*" [^]* "*#"
ComentarioLinea = "##" [^\r\n]*
TraditionalComment = "/*" [^]* "*/"


Identificador = [:jletter:] [:jletterdigit:]*
EnteroLiteral =  -? (0|[1-9][0-9]*)
DecimalLiteral =  [+-]? (0|[1-9][0-9]*) "." [0-9]+
BooleanoLiteral = "true" | "false"

%state STRING

%%

/* keywords */

<YYINITIAL> "database"          { return symbol(sym.DATABASE); }
<YYINITIAL> "use"               { return symbol(sym.USE); }
<YYINITIAL> "table"             { return symbol(sym.TABLE); }
<YYINITIAL> "int"               { return symbol(sym.INT, yytext()); }
<YYINITIAL> "float"             { return symbol(sym.FLOAT, yytext()); }
<YYINITIAL> "bool"              { return symbol(sym.BOOL, yytext()); }
<YYINITIAL> "string"            { return symbol(sym.STRING, yytext()); }
<YYINITIAL> "array"             { return symbol(sym.ARRAY, yytext()); }
<YYINITIAL> "null"              { return symbol(sym.NULL, yytext()); }
<YYINITIAL> "object"            { return symbol(sym.OBJECT, yytext()); }
<YYINITIAL> "store"             { return symbol(sym.STORE); }
<YYINITIAL> "at"                { return symbol(sym.AT); }
<YYINITIAL> "read"                { return symbol(sym.READ); }
<YYINITIAL> "fields"                { return symbol(sym.FIELDS); }
<YYINITIAL> "filter"                { return symbol(sym.FILTER); }
<YYINITIAL> "add"                { return symbol(sym.ADD); }


<YYINITIAL> {
  /* Identificador */ 
  {Identificador}                { return symbol(sym.IDENTIFIER, yytext()); }

  {EnteroLiteral}                { return symbol(sym.ENTEROLITERAL, Integer.parseInt(yytext()));}
  {DecimalLiteral}                { return symbol(sym.FLOATLITERAL, Double.parseDouble(yytext()));}
  {BooleanoLiteral}                { return symbol(sym.BOOLEANLITERAL, Boolean.parseBoolean(yytext()));}

  /* Inicio de Cadena */
  \"                             { string.setLength(0); yybegin(STRING); }

  /* Signos de agrupacion */
  "{"                            {return symbol(sym.LLOPEN);}
  "}"                            {return symbol(sym.LLCLOSE);}


  /* Delimitadores */
  ","                            {return symbol(sym.COMA);} 
  ";"                            {return symbol(sym.PCOMA);} 
  ":"                            {return symbol(sym.DPUNTOS);} 
  "*"                            {return symbol(sym.ALL);}

  /* Comentarios */
  {Comment}                      { /* ignore */ }

  /* Espacios en Blanco */
  {WhiteSpace}                   { /* ignore */ }
}

<STRING> {
  \"                             { yybegin(YYINITIAL); 
                                    return symbol(sym.STRING_LITERAL, 
                                    string.toString()); }

  [^\n\r\"\\]+                   { string.append( yytext() ); }
  \\t                            { string.append('\t'); }
  \\n                            { string.append('\n'); }

  \\r                            { string.append('\r'); }
  \\\"                           { string.append('\"'); }
  \\                             { string.append('\\'); }
}

/* error fallback */
.                              { System.out.println("Caracter no reconocido: " + yytext()); this.errors.add("Caracter no reconocido: " + yytext() + " en la linea: " + yyline); }
                

