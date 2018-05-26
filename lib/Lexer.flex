package pruebacup;
import java_cup.runtime.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
%%
%{
/*-*
* funciones y variables
*/
private void imprimir(String descripcion, String lexema,JTable tabla) {
   DefaultTableModel modelo = (DefaultTableModel)tabla.getModel();
   Object[] object = new Object[2];
   object[0] = lexema;
   object[1] = descripcion;
   modelo.addRow(object);
   tabla.setModel(modelo);
}
%}
/*-*
* Información sobre la clase generada
*/
%public 
%class AnalizadorLexico
%cupsym sym
%cup
%char
%column
%full
%ignorecase
%line
%unicode
/*-*
* Ajustes regulares
*/
IGUAL = "="
SALTO = \n|\r|\r\n
BLANCO= " "
SIGNO = ("+" | "-" | "*" | "/")
TXT = ","|"?"|"¿"|"$"|"."|"#"|"["|"]"|"%"|"#"|"!"|"¡"|[_|a-z|A-Z][a-z|A-Z|0-9|_]*
ENTERO = 0|[1-9][0-9]*
COMILLA="\""
BLANCO = [\n| |\t]
MS= {COMILLA}({TXT})+{COMILLA} | {COMILLA}({TXT})+{OTRO}+{COMILLA}
OTRO = ({BLANCO}({TXT})+)+
DECIMAL = [0-9][0-9]*"."[0-9]+

%%
";" {
  imprimir("Fin de instruccion",yytext(),tabla);
  return new Symbol(sym.punto_coma,yycolumn, yyline, yytext());
}
"," {
  imprimir("Simbolo de coma",yytext(),tabla);
  return new Symbol(sym.coma,yycolumn, yyline, yytext());
}
"{" {
  imprimir("Llave que abre",yytext(),tabla);
  return new Symbol(sym.llave_abre,yycolumn, yyline, yytext());
}
"}" {
  imprimir("Llave que cierra",yytext(),tabla);
  return new Symbol(sym.llave_cierra,yycolumn, yyline, yytext());
}
"(" {
  imprimir("Parentesis que abre",yytext(),tabla);
  return new Symbol(sym.Pabre,yycolumn, yyline, yytext());
}
")" {
  imprimir("Parentesis que cierra",yytext(),tabla);
  return new Symbol(sym.Pcierra,yycolumn, yyline, yytext());
}
"[" {
  imprimir("Corchete que abre",yytext(),tabla);
  return new Symbol(sym.Cabre,yycolumn, yyline, yytext());
}
"]" {
  imprimir("Corchete que cierra",yytext(),tabla);
  return new Symbol(sym.Ccierra,yycolumn, yyline, yytext());
}
{MS} { 
  imprimir("Mensaje", yytext(),tabla);
  return new Symbol(sym.mensage,yycolumn, yyline, yytext());
}
{SALTO} { imprimir("Salto de linea", yytext(),tabla); }
"principal" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.principal,yycolumn, yyline, yytext());
}
"principal" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.principal,yycolumn, yyline, yytext());
}
"metodo" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.metodo,yycolumn, yyline, yytext());
} 
"imprime" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.imprime,yycolumn, yyline, yytext());
}
"args" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.args,yycolumn, yyline, yytext());
}
"operacion" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.operacion,yycolumn, yyline, yytext());
} 
"entrada" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.entrada,yycolumn, yyline, yytext());
}
"lectura" {
  imprimir("Palabra reservada", yytext(),tabla);
  return new Symbol(sym.lectura,yycolumn, yyline, yytext());
}
{BLANCO} { imprimir("Espacio en blanco", yytext(),tabla); }
{TXT} { imprimir("Nombre de variable", yytext(),tabla); }
{ENTERO} { 
  imprimir("Numero entero", yytext(),tabla);
  return new Symbol(sym.entero,yycolumn, yyline, yytext()); 
}
{COMILLA} {imprimir("Comillas",yytext(),tabla);}
{DECIMAL} { 
  imprimir("Punto flotante", yytext(),tabla); 
  return new Symbol(sym.decimal,yycolumn, yyline, yytext());
}
{IGUAL} { 
  imprimir("Signo de igual", yytext(),tabla); 
  return new Symbol(sym.igual,yycolumn, yyline, yytext());
}
{SIGNO} { 
  imprimir("Operadores matemáticos", yytext(),tabla); 
  return new Symbol(sym.signo,yycolumn, yyline, yytext());
}
. {imprimir("Caracter inválido",yytext(),tabla); }