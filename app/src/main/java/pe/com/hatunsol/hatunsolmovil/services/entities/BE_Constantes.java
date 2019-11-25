package pe.com.hatunsol.hatunsolmovil.services.entities;

/**
 * Created by Sistemas on 05/01/2016.
 */
public class BE_Constantes {


    public class Resultado_Evaluacion {
        public static final int NoAprueba = 3;
    }

    public class Sync_Status {
        public static final int Sincronizado = 1;
        public static final int Pendiente = 2;
        public static final int Error = 3;
    }

    public class Activities {
        public static final int REGISTRAR_CREDITO = 1;
        public static final int AGENDAR = 2;

    }

    public class TipoUsuarios {
        public static final int Administrador = 1;
        public static final int ADO = 4;
        public static final int JefedeMarca = 38;//
        public static final int Supervisor = 29;
        public static final int Impulsador_Lucky = 33;
        public static final int Cliente = 40;
        public static final int JefeZonal = 2;//
        public static final int CONCREFAB = 45;
        public static final int Establecimiento = 26;
        public static final int Vendedor = 46;
        public static final int OtrosProductos = 47;

    }

    public class TipoVentaEstablecimiento {
        public static final int Obra = 1;
        public static final int Tienda = 2;
    }

    public class EstadoCivil {
        public static final int Soltero = 1;
        public static final int Casado = 2;
        public static final int Viudo = 3;
        public static final int Conviviente = 4;
        public static final int Divorciado = 5;
    }

    public class GradoInstruccion {
        public static final int Sin_Grado = 0;
        public static final int Primaria = 1;
        public static final int Secundaria = 2;
        public static final int Tecnica = 3;
        public static final int Superior = 4;
        public static final int Grado_Bachiller = 5;
        public static final int Titulado = 6;
        public static final int Colegiado = 7;
    }

    public class Filtro {
        public static final int Todos = 3;
    }

    public class EstadoEncuesta {
        public static final int Creado = 1;
        public static final int Revisado = 2;
        public static final int Aprobado = 3;
    }

    public class TipoDocumentoAdjunto {
        public static final int Block_de_Registro = 1;
        public static final int Carta_de_Presentacion = 2;
        public static final int Carta_CTA_BCP = 3;
        public static final int Convenio = 4;
        public static final int Ficha_RUC = 5;
        public static final int Copia_DNI = 6;
        public static final int Copia_Licencia = 7;
        public static final int Auditoria = 8;

    }

    public class TipoDocumento {
        public static final int DNI = 1;
        public static final int RUC = 2;
        public static final int CE = 3;
    }



    public class Operacion {
        public static final int Insertar = 1;
        public static final int Modificar = 2;
        public static final int Salir = 3;
        public static final int Ver = 4;
        public static final int Revizar = 5;
        public static final int NoOcultar = 6;
        public static final int AbrirVentana = 7;
    }

    public class Banco {

        public static final int MIBANCO = 3;

    }


    public class TipoValor {
        public static final int SINVALOR = 1;
        public static final int ENTERO = 2;
        public static final int STRING = 3;
        public static final int DECIMAL = 4;
    }



    public class EstadoProceso {
        public static final int Contacto = 1;
        public static final int Prospecto = 2;
        public static final int Gestion = 3;
        public static final int Clientes = 4;
        public static final int Evaluacion = 5;
        public static final int Aprobado = 6;
        public static final int Programado = 7;
        public static final int Activado = 8;
        public static final int Rechazado = 9;
        public static final int Desistio = 10;
        public static final int NoCalifica = 11;
        public static final int NoQuiere = 12;
        public static final int Monitor = 13;

        public static final int Observado = 200;
    }

    public class Formalidad {
        public static final int Formal = 1;
        public static final int Informal = 2;
    }

    public class TipoEstablecimiento {
        public static final int Alquilado = 2;
        public static final int Propio = 1;
    }

    public class CasaPropia {
        public static final int Si = 1;
        public static final int No = 2;


    }

    public class Canal {
        public static final int Fuerza_Venta = 1;
        public static final int Establecimiento = 2;
        public static final int Call_Center = 3;
        public static final int Banco = 4;
        public static final int Tienda = 5;
        public static final int TComunica = 6;
        public static final int Portero = 7;
        public static final int Volantero = 8;
        public static final int Activacion_Mercado = 9;
        public static final int Puerta = 10;
        public static final int Maestro = 11;
        public static final int Web = 12;
        public static final int Movil = 13;
        public static final int Redes_Sociales = 14;
        public static final int Monitor = 15;
        public static final int ConcreFAB = 16;
        public static final int Carpa = 17;
        public static final int Sin_Canal = 0;
    }

    public class TipoTrabajo {
        public static final int Independiente = 1;
        public static final int Dependiente = 2;
        public static final int Ama_Casa = 3;
    }

    public class Sexo {
        public static final int Masculino = 1;
        public static final int Femenino = 2;


    }

    public class TipoPersona {
        public static final int Titular = 1;
        public static final int Conyuge = 2;
        public static final int Garante_Propiedad = 3;
        public static final int Garante_Ingresos = 4;
        public static final int Conyuge_Garante_Propiedad = 5;
        public static final int Conyuge_Garante_Ingresos = 6;
        public static final int Empresa = 7;
        public static final int Persona_Contacto= 8;
    }

    public class TipoLugar {
        public static final int Local = 1;
        public static final int Establecimiento = 2;
        public static final int Agencia = 3;
    }

    public class SustentoIngreso{
        public static final int Recibo_Honorario = 1;
        public static final int Boletas_Pago = 2;
        public static final int Documento_Pago = 3;
    }

    public class EstadoAfiliacion {
        public static final int Registrado = 1;
        public static final int Pendientes = 2;
        public static final int Afiliado = 3;
        public static final int Observado = 4;
        public static final int Desistio = 5;
    }

    public class TipoPlanTrabajo {
        public static final int PlanTrabajo = 1;
        public static final int Alternativa = 2;
    }

    public class TipoDocumentoAdjuntoCredito {
        public static final int Otros = 0;
        public static final int DNI = 1;
        public static final int Croquis = 8;
        public static final int ReciboServicios = 9;
    }

}
