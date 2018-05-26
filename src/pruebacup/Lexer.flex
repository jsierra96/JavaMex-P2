package pruebacup;
import java_cup.runtime.*;
%%
%{

%}
/*-*
* Información sobre la clase generada
*/
%public 
%class parte2
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
  return new Symbol(sym.punto_coma,yycolumn, yyline, yytext());
}
"," {
  return new Symbol(sym.coma,yycolumn, yyline, yytext());
}
"{" {
  return new Symbol(sym.llave_abre,yycolumn, yyline, yytext());
}
"}" {
  return new Symbol(sym.llave_cierra,yycolumn, yyline, yytext());
}
"(" {
  return new Symbol(sym.Pabre,yycolumn, yyline, yytext());
}
")" {
  return new Symbol(sym.Pcierra,yycolumn, yyline, yytext());
}
"[" {
  return new Symbol(sym.Cabre,yycolumn, yyline, yytext());
}
"]" {
  return new Symbol(sym.Ccierra,yycolumn, yyline, yytext());
}
{MS} {
  return new Symbol(sym.mensage,yycolumn, yyline, yytext());
}
{SALTO} {
  System.out.println("Salto de linea"); }
"principal" {
  return new Symbol(sym.principal,yycolumn, yyline, yytext());
}
"principal" {
  return new Symbol(sym.principal,yycolumn, yyline, yytext());
}
"metodo" {
  return new Symbol(sym.metodo,yycolumn, yyline, yytext());
} 
"entero" {
  return new Symbol(sym.entero,yycolumn, yyline, yytext());
}
"decimal" {
  return new Symbol(sym.decimal,yycolumn, yyline, yytext());
} 
"imprime" {
  return new Symbol(sym.imprime,yycolumn, yyline, yytext());
}
"args" {
  return new Symbol(sym.args,yycolumn, yyline, yytext());
}
"operacion" {
  return new Symbol(sym.operacion,yycolumn, yyline, yytext());
} 
"lectura" {
  return new Symbol(sym.lectura,yycolumn, yyline, yytext());
}
{TXT} { 
  return new Symbol(sym.nombre,yycolumn, yyline, yytext()); 
}
{ENTERO} {
  return new Symbol(sym.ent,yycolumn, yyline, yytext()); 
}

{DECIMAL} { 
  return new Symbol(sym.dec,yycolumn, yyline, yytext());
}
"=" {  
  return new Symbol(sym.igual,yycolumn, yyline, yytext());
}
{BLANCO} {
}
{SIGNO} { 
  return new Symbol(sym.signo,yycolumn, yyline, yytext());
}
. {System.out.println("Caracter inválido: "+yytext()); }