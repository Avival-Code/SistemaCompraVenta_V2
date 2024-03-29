package com.example.sistemacompraventa_v2.utilities;

import com.example.sistemacompraventa_v2.entidades.Domicilio;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.entidades.Usuario;

public class StringValidator {
    private final int minTamanoNombre = 3;
    private final int maxTamanoNombre = 30;
    private final int minTamanoApellido = 3;
    private final int maxTamanoApellido = 20;
    private final int minTamanoUsuario = 5;
    private final int maxTamanoUsuario = 20;
    private final int minTamanoCorreo = 10;
    private final int maxTamanoCorreo = 40;
    private final int minTamanoContrasena = 8;
    private final int maxTamanoContrasena = 20;
    private final int tamanoTelefono = 10;
    private final int minDireccion = 10;
    private final int maxDireccion = 200;

    public boolean IsUsuarioInformationValid( Usuario student, String passwordConfirm ) {
        return AreNamesValid( student.getNombres() ) && AreLastNamesValid( student.getApellidos() ) &&
                IsTelephoneValid( student.getTelefono() ) && IsEmailValid( student.getCorreoElectronico() ) &&
                IsPasswordValid( student.getContrasena() ) && DoPasswordsMatch( student.getContrasena(), passwordConfirm );
    }

    public boolean IsDomicilioInformationValid( Domicilio domicilio ) {
        return IsDomicilioStringValid( domicilio.getCalle() ) && IsDomicilioStringValid( domicilio.getColonia() ) &&
                IsDomicilioStringValid( domicilio.getMunicipio() ) && IsDomicilioStringValid( domicilio.getEstado() ) &&
                IsDomilicioNumberValid( Integer.toString( domicilio.getNumerInterno() ) ) &&
                IsDomilicioNumberValid( Integer.toString( domicilio.getNumeroExterno() ) ) &&
                IsDomicilioDescripcionValid( domicilio.getDescripcion() );
    }

    public boolean IsPublicacionInformationValid( Publicacion publicacion ) {
        return IsPublicacionStringValid( publicacion.getNombre() ) && IsPublicacionStringValid( publicacion.getDescripcion() ) &&
                IsPublicacionNumberValid( Integer.toString( publicacion.getCategoria().ordinal() ) ) &&
                IsPublicacionNumberValid( Integer.toString( ( int )publicacion.getPrecio() ) ) &&
                IsPublicacionNumberValid( Integer.toString( publicacion.getCantidad_disponible() ) ) &&
                IsPublicacionStringValid( publicacion.getUnidad_medida() );
    }

    public boolean isUserUpdateInformationValid( Usuario usuario ) {
        return AreNamesValid( usuario.getNombres() ) && AreLastNamesValid( usuario.getApellidos() ) &&
                IsEmailValid( usuario.getCorreoElectronico() ) && IsTelephoneValid( usuario.getTelefono() );
    }

    public boolean IsLoginInformationValid( String username, String password ) {
        return IsUsernameValid( username ) && IsPasswordValid( password );
    }

    public boolean IsUsernameValid( String username ) {
        return IsStringValidSize( username, minTamanoUsuario, maxTamanoUsuario ) && !HasInvalidCharacter( username ) &&
                !HasNumbers( username );
    }

    public boolean AreNamesValid( String name ) {
        return IsStringValidSize( name, minTamanoNombre, maxTamanoNombre ) && !HasInvalidCharacter( name ) &&
                !HasNumbers( name );
    }

    public boolean AreLastNamesValid( String lastNames ) {
        return IsStringValidSize( lastNames, minTamanoApellido, maxTamanoApellido ) && !HasInvalidCharacter( lastNames ) &&
                !HasNumbers( lastNames );
    }

    public boolean IsTelephoneValid( String telephone ) {
        return telephone.length() == tamanoTelefono && HasOnlyNumbers( telephone );
    }

    public boolean IsEmailValid( String email ) {
        return IsStringValidSize( email, minTamanoCorreo, maxTamanoCorreo ) && HasSingleAtChar( email ) &&
                !HasInvalidCharacter( email ) && !HasSpaces( email );
    }

    public boolean IsPasswordValid( String password ) {
        return IsStringValidSize( password, minTamanoContrasena, maxTamanoContrasena ) && !HasInvalidCharacter( password ) &&
                !HasSpaces( password );
    }

    public boolean DoPasswordsMatch( String password, String confirmPassword ) {
        return password.equals( confirmPassword );
    }

    public boolean IsDomicilioStringValid( String string ) {
        return IsStringValidSize( string, 3, 50 ) && !HasInvalidCharacter( string );
    }

    public boolean IsDomilicioNumberValid( String number ) {
        return HasOnlyNumbers( number ) && IsStringValidSize( number, 1, 5 );
    }

    public boolean IsDomicilioDescripcionValid( String descripcion ) {
        return !HasNumbers( descripcion ) && IsStringValidSize( descripcion, 5, 100 );
    }

    public boolean IsPublicacionStringValid( String string ) {
        return IsStringValidSize( string, 3, 50 ) && !HasInvalidCharacter( string );
    }

    public boolean IsPublicacionNumberValid( String number ) {
        return HasOnlyNumbers( number ) && IsStringValidSize( number, 1, 5 );
    }

    public boolean IsPublicacionDescripcionValid( String descripcion ) {
        return !HasNumbers( descripcion ) && IsStringValidSize( descripcion, 5, 200 );
    }

    private boolean IsStringValidSize( String input, int minSize, int maxSize ) {
        return ( input.length() >= minSize && input.length() <= maxSize );
    }

    private boolean HasNumbers( String input ) {
        boolean hasNumbers = false;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( Character.isDigit( currentCharacter ) ) {
                hasNumbers = true;
            }
        }
        return hasNumbers;
    }

    private boolean HasSpaces( String input ) {
        boolean hasSpaces = false;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( currentCharacter == ' ' ) {
                hasSpaces = true;
            }
        }
        return hasSpaces;
    }

    private boolean HasSingleAtChar( String input ) {
        int atCounter = 0;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( currentCharacter == '@' ) {
                atCounter += 1;
            }
        }
        return atCounter == 1;
    }

    private boolean HasInvalidCharacter( String input ) {
        boolean hasInvalidCharacter = false;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( currentCharacter == '|' || currentCharacter == ';' ||
                    currentCharacter == '=' || currentCharacter == 39 ) {
                hasInvalidCharacter = true;
            }
        }
        return hasInvalidCharacter;
    }

    private boolean HasOnlyNumbers( String input ) {
        boolean hasOnlyNumbers = true;
        char[] testInput = input.toCharArray();
        for( char currentCharacter : testInput ) {
            if( !Character.isDigit( currentCharacter ) ) {
                hasOnlyNumbers = false;
            }
        }
        return hasOnlyNumbers;
    }
}
