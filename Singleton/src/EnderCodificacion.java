public class EnderCodificacion {
    //método para cifrar el texto tipo Ender,
    public static String cifradoEnder(String texto) {
        StringBuilder strb = new StringBuilder(texto);
        return strb.reverse().toString();
    }
}
