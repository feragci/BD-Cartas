import java.sql.*;

public class Pokedex {

    public static void mostrarTodasCartas() {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            String consulta = "SELECT * FROM cartas";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);

            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int num_carta = resultado.getInt("id_carta");
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String sub_tipo = resultado.getString("sub_tipo");
                String rareza = resultado.getString("rareza");
                String expansion = resultado.getString("expansion_poke");

                System.out.println("==========================");
                System.out.println("Número de carta: " + num_carta);
                System.out.println("Nombre: " + nombre);
                System.out.println("Tipo: " + tipo);
                System.out.println("SubTipo: " + sub_tipo);
                System.out.println("Rareza: " + rareza);
                System.out.println("Expansión: " + expansion);
                System.out.println("==========================");
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void mostrarCarta(int num_carta) {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            String consulta = "SELECT * FROM cartas WHERE id_carta=?";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, num_carta);

            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String sub_tipo = resultado.getString("sub_tipo");
                String rareza = resultado.getString("rareza");
                String expansion = resultado.getString("expansion_poke");

                System.out.println("---------------------------");
                System.out.println("Número de carta: " + num_carta);
                System.out.println("Nombre: " + nombre);
                System.out.println("Tipo: " + tipo);
                System.out.println("SubTipo: " + sub_tipo);
                System.out.println("Rareza: " + rareza);
                System.out.println("Expansión: " + expansion);
                System.out.println("---------------------------");

            } else {
                System.out.println("Carta no encontrada.");
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void filtrarCartas(int opcion, String valor) {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";

        String consulta = "";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado;

            switch (opcion) {
                case 1:
                    consulta = "SELECT * FROM cartas WHERE tipo = '" + valor + "'";
                    break;
                case 2:
                    consulta = "SELECT * FROM cartas WHERE sub_tipo = '" + valor + "'";
                    break;
                case 3:
                    consulta = "SELECT * FROM cartas WHERE rareza = '" + valor + "'";
                    break;
                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                int num_carta = resultado.getInt("id_carta");
                String nombre = resultado.getString("nombre");
                String tipo = resultado.getString("tipo");
                String sub_tipo = resultado.getString("sub_tipo");
                String rareza = resultado.getString("rareza");
                String expansion = resultado.getString("expansion_poke");

                System.out.println("==========================");
                System.out.println("Número: " + num_carta);
                System.out.println("Nombre: " + nombre);
                System.out.println("Tipo: " + tipo);
                System.out.println("SubTipo: " + sub_tipo);
                System.out.println("Rareza: " + rareza);
                System.out.println("Expansión: " + expansion);
                System.out.println("==========================");
            }

            resultado.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }

    public static void añadirCarta(int num_carta, String nombre, String tipo, String sub_tipo, String rareza, String expansion_poke) {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            String consulta = "INSERT INTO cartas (id_carta, nombre, tipo, sub_tipo, rareza, expansion_poke) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);

            sentencia.setInt(1, num_carta);
            sentencia.setString(2, nombre);
            sentencia.setString(3, tipo);
            sentencia.setString(4, sub_tipo);
            sentencia.setString(5, rareza);
            sentencia.setString(6, expansion_poke);

            sentencia.executeUpdate();
            System.out.println("Carta añadida correctamente.");

            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void borrarCarta(int num_carta) {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            String consulta = "DELETE FROM cartas WHERE id_carta=?";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            sentencia.setInt(1, num_carta);

            int filas = sentencia.executeUpdate();

            if (filas == 1) {
                System.out.println("Carta eliminada.");
            } else {
                System.out.println("Carta no encontrada.");
            }

            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void actualizarCarta(int num_carta, String nombre, String tipo, String sub_tipo, String rareza, String expansion_poke) {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);

            String consulta = "UPDATE cartas SET nombre=?, tipo=?, sub_tipo=?, rareza=?, expansion_poke=? WHERE num_carta=?";
            PreparedStatement sentencia = conexion.prepareStatement(consulta);

            sentencia.setString(1, nombre);
            sentencia.setString(2, tipo);
            sentencia.setString(3, sub_tipo);
            sentencia.setString(4, rareza);
            sentencia.setString(5, expansion_poke);
            sentencia.setInt(6, num_carta);

            int filas = sentencia.executeUpdate();

            if (filas == 1) {
                System.out.println("Carta actualizada.");
            } else {
                System.out.println("Carta no encontrada.");
            }

            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public static String obtenerTodasCartas() {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";
        StringBuilder sb = new StringBuilder();
        String sql = "SELECT * FROM cartas";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                sb.append("Número de Carta: ").append(rs.getInt("id_carta")).append("\n");
                sb.append("Nombre: ").append(rs.getString("nombre")).append("\n");
                sb.append("Tipo: ").append(rs.getString("tipo")).append("\n");
                sb.append("SubTipo: ").append(rs.getString("sub_tipo")).append("\n");
                sb.append("Rareza: ").append(rs.getString("rareza")).append("\n");
                sb.append("Expansión: ").append(rs.getString("expansion_poke")).append("\n");
                sb.append("--------------------------\n");
            }

        } catch (SQLException e) {
            sb.append("Error al obtener cartas: ").append(e.getMessage());
        }

        return sb.toString();
    }

    public static String obtenerCartaPorID(String id) {
        final String URL = "jdbc:mysql://localhost:3306/pokemon_tcg_pocket";
        final String USER = "root";
        final String PASSWORD = "1234";
        StringBuilder sb = new StringBuilder();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cartas WHERE id_carta = ?")) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id_carta")).append("\n");
                sb.append("Nombre: ").append(rs.getString("nombre")).append("\n");
                sb.append("Tipo: ").append(rs.getString("tipo")).append("\n");
                sb.append("SubTipo: ").append(rs.getString("sub_tipo")).append("\n");
                sb.append("Rareza: ").append(rs.getString("rareza")).append("\n");
                sb.append("Expansion: ").append(rs.getString("expansion_poke")).append("\n");


            } else {
                sb.append("No se encontró una carta con ID ").append(id);
            }

        } catch (SQLException e) {
            sb.append("Error al buscar carta: ").append(e.getMessage());
        }
        return sb.toString();
    }
}
