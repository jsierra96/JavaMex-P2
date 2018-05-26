package pruebacup;

import java.io.File;

public class PruebaCup {

    public static void main(String[] args) {
        String archivo=System.getProperty("user.dir")+"/src/pruebacup/Lexer.flex";
        File file=new File(archivo);
	jflex.Main.generate(file);
    }
    
}
