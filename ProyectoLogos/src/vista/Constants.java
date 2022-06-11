package vista;

public class Constants {

    public static String ESTRELLA_COLORES() {
        return "for(i=0;i<130;i=i+1){\n"
                + "   CambiarColor[i*13, i*26, i*51];\n"
                + "   Avanzar[i*5];\n"
                + "   Girar[150];\n"
                + "}";
    }

    public static String CUADRADO_FUNCION() {
        return "func potencia () {\n"
                + "    retorno = 1;\n"
                + "    for(aux=0; aux<$2; aux=aux+1){\n"
                + "        retorno = retorno*$1;\n"
                + "    }\n"
                + "    return retorno;\n"
                + "}\n"
                + "for(i=0; i<24; i=i+1){\n"
                + "    Avanzar[potencia(i,2)];\n"
                + "    CambiarColor[\n"
                + "      5*potencia(i,1),\n"
                + "      5*potencia(i,2),\n"
                + "      5*potencia(i,3)\n"
                + "   ];\n"
                + "    Girar[90];\n"
                + "}";
    }

    public static String FLOR_ANIDADA() {
        return "proc circulo(){\n"
                + "   for(aux=0; aux<360; aux=aux+1){\n"
                + "      CambiarColor[$1,$2,$3];\n"
                + "      Avanzar[2];\n"
                + "      Girar[1];\n"
                + "   }\n"
                + "}\n"
                + "proc flor(){\n"
                + "   for(i=0;i<8;i=i+1){\n"
                + "      circulo((i+1)*30, (i+1)*32, (i+1)*60);\n"
                + "      Girar[45];\n"
                + "   }\n"
                + "}\n"
                + "flor();";
    }

    public static String REGLA_FUNC() {
        return "func Regla() {\n"
                + "    if($1>0){\n"
                + "	Avanzar[10];\n"
                + "	Girar[90];\n"
                + "	Avanzar[10];\n"
                + "	Girar[180];\n"
                + "	Avanzar[20];\n"
                + "	Girar[180];\n"
                + "	Avanzar[10];\n"
                + "	Girar[270];\n"
                + "	Avanzar[10];\n"
                + "	Regla($1-1);\n"
                + "    }\n"
                + "    return 0;\n"
                + "}\n"
                + "\n"
                + "Regla(TAMANIO);";
    }

    public static String HILBERT() {
        return "func hilbert(){\n"
                + "    if($1==0){\n"
                + "       return 0;\n"
                + "}\n"
                + "    Girar[$2];\n"
                + "    hilbert($1 - 1,-$2);\n"
                + "    Avanzar[10];\n"
                + "    Girar[-$2];\n"
                + "    hilbert($1 - 1,$2);\n"
                + "    Avanzar[10];\n"
                + "    hilbert($1 - 1,$2);\n"
                + "    Girar[-$2];\n"
                + "    Avanzar[10];\n"
                + "    hilbert($1 - 1,-$2);\n"
                + "    Girar[$2];\n"
                + "    \n"
                + "}\n"
                + "hilbert(TAMANIO,ROTACION);";
    }

    public static String SPYRO_PROC() {
        return "func circulo(){\n"
                + "for(i=0; i<366; i=i+1){\n"
                + "    Avanzar[2];\n"
                + "    Girar[1];\n"
                + "}\n"
                + "}\n"
                + "\n"
                + "func espirografo(){\n"
                + "for(j=0; j<45; j=j+1){\n"
                + "CambiarColor[j*30,j*40,j*20];\n"
                + "circulo();\n"
                + "Girar[90];\n"
                + "}\n"
                + "}\n"
                + "espirografo(); ";
    }

    public static String SPYRO_CICLO() {
        return "for(i=0;i<200;i=i+1){\n"
                + "   CambiarColor[0, i*26, i*51];\n"
                + "   Avanzar[i*4];\n"
                + "   Girar[145];\n"
                + "}";
    }

}
