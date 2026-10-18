public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Juan");
        usuario.activarSuscripcion(ServicioStreaming.DISNEY);
        usuario.activarSuscripcion(ServicioStreaming.WARNER);

        CatalogoPeliculas disney = new SuscripcionDecorator(new CatalogoDisney(), usuario);
        CatalogoPeliculas paramount = new SuscripcionDecorator(new CatalogoParamount(), usuario);
        CatalogoPeliculas warner = new SuscripcionDecorator(new CatalogoWarner(), usuario);

        // Prueba 1: Acceso a Disney (Permitido)
        System.out.println("Disney: " + disney.obtenerPeliculas());

        // Prueba 2: Acceso a Warner (Permitido)
        System.out.println("Warner: " + warner.obtenerPeliculas());

        // Prueba 3: Acceso a Paramount (Denegado)
        try {
            System.out.println("Paramount: " + paramount.obtenerPeliculas());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Activar Paramount y reintentar
        System.out.println("\nActivando suscripcion a Paramount...");
        usuario.activarSuscripcion(ServicioStreaming.PARAMOUNT);

        System.out.println("Paramount: " + paramount.obtenerPeliculas());
    }
}