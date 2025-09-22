import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int opcion = -1;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Visualizar todas las cartas");
            System.out.println("2. Visualizar una carta por su número");
            System.out.println("3. Filtrar cartas por tipo, subtipo o rareza");
            System.out.println("4. Añadir una nueva carta");
            System.out.println("5. Borrar una carta por su número");
            System.out.println("6. Actualizar una carta existente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        System.out.println("Mostrando todas las cartas...");
                        Pokedex.mostrarTodasCartas();
                        break;

                    case 2:
                        System.out.print("Número de carta a buscar: ");
                        int numCartaBuscar = teclado.nextInt();
                        teclado.nextLine();
                        Pokedex.mostrarCarta(numCartaBuscar);
                        break;

                    case 3:
                        System.out.println("Filtrar por:");
                        System.out.println("1. Tipo");
                        System.out.println("2. SubTipo");
                        System.out.println("3. Rareza");
                        System.out.print("Elige una opción: ");
                        int opcionFiltro = teclado.nextInt();
                        teclado.nextLine();

                        System.out.print("Introduce el valor a filtrar: ");
                        String valorFiltro = teclado.nextLine();

                        Pokedex.filtrarCartas(opcionFiltro, valorFiltro);
                        break;

                    case 4:
                        System.out.print("Número de carta: ");
                        int nuevoNum = teclado.nextInt();
                        teclado.nextLine(); // Limpiar buffer

                        System.out.print("Nombre: ");
                        String nuevoNombre = teclado.nextLine();

                        System.out.print("Tipo: ");
                        String nuevoTipo = teclado.nextLine();

                        System.out.print("SubTipo: ");
                        String nuevoSubTipo = teclado.nextLine();

                        System.out.print("Rareza: ");
                        String nuevaRareza = teclado.nextLine();

                        System.out.print("Expansión: ");
                        String nuevaExpansion = teclado.nextLine();

                        Pokedex.añadirCarta(nuevoNum, nuevoNombre, nuevoTipo, nuevoSubTipo, nuevaRareza, nuevaExpansion);
                        break;

                    case 5:
                        System.out.print("Número de carta a borrar: ");
                        int numBorrar = teclado.nextInt();
                        teclado.nextLine();
                        Pokedex.borrarCarta(numBorrar);
                        break;

                    case 6:
                        System.out.print("Número de carta a actualizar: ");
                        int numActualizar = teclado.nextInt();
                        teclado.nextLine();

                        System.out.print("Nuevo nombre: ");
                        String nombreAct = teclado.nextLine();

                        System.out.print("Nuevo tipo: ");
                        String tipoAct = teclado.nextLine();

                        System.out.print("Nuevo subtipo: ");
                        String subTipoAct = teclado.nextLine();

                        System.out.print("Nueva rareza: ");
                        String rarezaAct = teclado.nextLine();

                        System.out.print("Nueva expansión: ");
                        String expansionAct = teclado.nextLine();

                        Pokedex.actualizarCarta(numActualizar, nombreAct, tipoAct, subTipoAct, rarezaAct, expansionAct);
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }

            } catch (InputMismatchException ime) {
                System.out.println("Error: Entrada no válida.");
                teclado.nextLine(); // Limpiar buffer
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 0);

        teclado.close();
    }
}