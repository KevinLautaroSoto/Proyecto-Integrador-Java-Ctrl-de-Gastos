import Categoria.Categoria;
import Gastos.Gastos;
import User.User;
import Gastos.FiltroCategorias;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        User sujeto1 = new User(1, "Ariel", "ariel@email.com","contraseña");

        //Creo una lista de Categorias para facilitar la carga y posterior filtrado de los Gastos.
        Categoria comida = new Categoria(1, "comida");
        Categoria ropa = new Categoria(2, "ropa");
        Categoria impuestos = new Categoria(3, "impuesto");
        Categoria entretenimiento = new Categoria(4, "entretenimiento");
        List<Categoria> listaCategorias = new ArrayList<>();
        listaCategorias.add(comida);
        listaCategorias.add(ropa);
        listaCategorias.add(impuestos);
        listaCategorias.add(entretenimiento);

        Date fecha1 = new Date(2023, Calendar.JANUARY, 12);


        //creo algunos gastos para no tener la lista vacia.
        Gastos prueba1 = new Gastos(1, fecha1, 130.30, "comida en restaurant", comida);
        Gastos prueba2 = new Gastos(2, fecha1, 23.43, "caramelos", comida);
        Gastos prueba3 = new Gastos(3, fecha1, 250.90, "remera", ropa);

        Scanner scanner = new Scanner(System.in);

        int contIdGastos = 3;
        int contCatGast = 4;
        List<Gastos> listaGastos =new ArrayList<>();
        int option;

        //cargo los gastos creados a la lista.
        listaGastos.add(prueba1);
        listaGastos.add(prueba2);
        listaGastos.add(prueba3);

        do {
            System.out.println("MENU:");
            System.out.println("1- Lista de Gastos.");
            System.out.println("2- Ingresar nuevo Gasto.");
            System.out.println("3- Lista de Categorias de Gastos.");
            System.out.println("4- Ingresar nueva Categoria de Gasto.");
            System.out.println("5- Filtrar Gastos por categoria.");
            System.out.println("9- Salir.");
            System.out.println(" ");

            System.out.print("Ingrese la opcion: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Lista de gastos: ");
                    for (Gastos gastos : listaGastos) {
                        System.out.println(gastos.getIdGastos() + "_ " + gastos.getDescripcion() + " - $" + gastos.getMonto() + " - Categoria: " + gastos.getCategoria().getName() + " - Fecha: " + gastos.getFecha());
                    }
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println("Ingresar un nuevo gasto: ");
                    System.out.println(" ");
                    System.out.println("Seleccione la categoria del gasto a guardar: ");
                    for(Categoria categoria : listaCategorias) {
                        System.out.println(categoria.getIdCategoria() + " " + categoria.getName());
                    }
                    int catScan = scanner.nextInt();
                    int catAux = catScan - 1;
                    scanner.nextLine();
                    contIdGastos++;

                    System.out.println("Ingrese la descripcion del  gasto: ");
                    String descAux = scanner.nextLine();

                    Double montoAux = null;
                    while (montoAux == null) {
                        System.out.println("Ingrese el monto del gasto: ");
                        String montoString = scanner.nextLine();
                        try {
                            montoAux = Double.parseDouble(montoString);
                        } catch (NumberFormatException e) {
                            System.out.println("Error. Ingrese un monto válido: ");
                        }
                    }

                    Gastos gAux = new Gastos(contIdGastos, fecha1, montoAux, descAux, listaCategorias.get(catAux));
                    listaGastos.add(gAux);
                    System.out.println("Nuevo gasto ingresado!");
                    break;

                case 3:
                    System.out.println("Lista de Categorias de Gastos: ");
                    for(Categoria categoria : listaCategorias) {
                        System.out.println(categoria.getIdCategoria() + " " + categoria.getName());
                    }
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la nueva categoria: ");
                    contCatGast++;
                    scanner.nextLine();
                    String catNueStr = scanner.nextLine();
                    Categoria catNueId = new Categoria(contCatGast, catNueStr);
                    listaCategorias.add(catNueId);
                    break;
                case 5:
                    System.out.println("Elija la categoria para el filtro: ");
                    for(Categoria categoria : listaCategorias) {
                        System.out.println(categoria.getIdCategoria() + " " + categoria.getName());
                    }
                    System.out.println(" ");
                    int catFiltro = scanner.nextInt();
                    FiltroCategorias filtroC = new FiltroCategorias(listaCategorias.get(catFiltro - 1).getName());
                    for (Gastos gastos : listaGastos) {
                        if (filtroC.cumpleFiltro(gastos)) {
                            System.out.println(gastos.getIdGastos() + "_ " + gastos.getDescripcion() + " - $" + gastos.getMonto() + " - Categoria: " + gastos.getCategoria().getName() + " - Fecha: " + gastos.getFecha());
                        }
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (option != 9);

        scanner.close();
    }
}