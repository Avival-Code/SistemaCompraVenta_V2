package com.example.sistemacompraventa_v2.utilities;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sistemacompraventa_v2.BuscarActivity;
import com.example.sistemacompraventa_v2.MainActivity;
import com.example.sistemacompraventa_v2.R;
import com.example.sistemacompraventa_v2.entidades.Publicacion;
import com.example.sistemacompraventa_v2.entidades.Usuario;
import com.example.sistemacompraventa_v2.enumeraciones.Categoria;
import com.example.sistemacompraventa_v2.enumeraciones.TipoUsuario;
import com.example.sistemacompraventa_v2.sesionusuario.LoginSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiRequests {
    private String loginURL = "http://192.168.1.68:5000/login";
    private String usuariosURL = "http://192.168.1.68:5000/usuarios";
    private String usuarioEspecificoURL = "http://192.168.1.68:5000/usuarios/";
    private String publicacionesURL = "http://192.168.1.68:5000/publicaciones";
    private ObjetosJson objetos = null;

    public ApiRequests() { objetos = new ObjetosJson(); }
/*
    public void login( final Activity currentActivity, final String usuario, final String contrasena ) {
        threads.post( new LoginRequest( currentActivity, usuario, contrasena ) );
    }

    public void getUsuario( final Context currentContext, final int claveUsuario, final String accessToken ) {
        threads.post( new GetUsuario( currentContext, claveUsuario, accessToken ) );
    }

    static class LoginRequest implements Runnable {
        private Activity currentActivity;
        private ObjetosJson objetos = null;
        private String loginURL = "http://201.105.180.242:5000/login";
        private String usuarioEspecificoURL = "http://201.105.180.242:5000/usuarios/";
        private String usuario;
        private String contrasena;

        public LoginRequest( Activity sourceActivity, String usuarioIn, String contrasenaIn ) {
            currentActivity = sourceActivity;
            usuario = usuarioIn;
            contrasena = contrasenaIn;
            objetos = new ObjetosJson();
        }

        @Override
        public void run() {
            RequestQueue request = Volley.newRequestQueue( currentActivity.getBaseContext() );
            try {
                JSONObject payload = objetos.crearObjetoJson( usuario, contrasena );
                JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.POST, loginURL, payload, new Response.Listener< JSONObject >() {
                    @Override
                    public void onResponse( JSONObject response ) {
                        if( response != null ) {
                            LoginSession.getInstance().login( response.optInt( "clave_usuario" ), response.optString( "access_token" ) );
                            ( ( MainActivity )currentActivity ).setUserMenu();
                            Toast.makeText( currentActivity.getBaseContext(), R.string.login_exitoso, Toast.LENGTH_SHORT ).show();
                            //getUsuario( currentActivity.getBaseContext(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
                        } else {
                            Toast.makeText( currentActivity.getBaseContext(), R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse( VolleyError error ) {
                        Toast.makeText( currentActivity.getBaseContext(), R.string.login_fracaso, Toast.LENGTH_SHORT ).show();
                    }
                } );
                request.add( objectRequest );
            } catch( org.json.JSONException json ) {
                json.printStackTrace();
            }
        }

        public void getUsuario( final Context currentContext, final int claveUsuario, final String accessToken ) {
            RequestQueue request = Volley.newRequestQueue( currentContext );
            try {
                String requestURL = usuarioEspecificoURL + claveUsuario;
                JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse( JSONObject response ) {
                        if( response != null ) {
                            Usuario temp = new Usuario( response.optInt( "clave_usuario" ), response.optString( "nombres" ), response.optString( "apellidos" ),
                                    response.optString( "correo_electronico" ), response.optString("telefono" ), response.optString( "nombre_usuario" ),
                                    response.optString( "contrasena" ), ( float )response.optDouble( "calificacion" ), TipoUsuario.values() [ response.optInt( "tipo_usuario" ) ] );
                            LoginSession.getInstance().setUsuario( temp );
                        } else {
                            Toast.makeText( currentContext, R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse( VolleyError error ) {
                        Toast.makeText( currentContext, R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                    }
                } ) {
                    @Override
                    public Map< String, String > getHeaders() throws AuthFailureError {
                        HashMap< String, String > headers = new HashMap< String, String > ();
                        headers.put( "Authorization", "Bearer " + accessToken );
                        return headers;
                    }
                };
                request.add( objectRequest );
            } catch( Exception exception ) { exception.printStackTrace(); }
        }
    }

    static class GetUsuario implements Runnable {
        private Context currentContext;
        private int claveUsuario;
        private String usuarioEspecificoURL = "http://192.168.1.68:5000/usuarios/";
        private String accessToken;

        public GetUsuario( Context currentContextIn, int claveUsuarioIn, String accessTokenIn ) {
            currentContext = currentContextIn;
            claveUsuario = claveUsuarioIn;
            accessToken = accessTokenIn;
        }
        @Override
        public void run() {
            RequestQueue request = Volley.newRequestQueue( currentContext );
            try {
                String requestURL = usuarioEspecificoURL + claveUsuario;
                JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse( JSONObject response ) {
                        if( response != null ) {
                            Usuario temp = new Usuario( response.optInt( "clave_usuario" ), response.optString( "nombres" ), response.optString( "apellidos" ),
                                    response.optString( "correo_electronico" ), response.optString("telefono" ), response.optString( "nombre_usuario" ),
                                    response.optString( "contrasena" ), ( float )response.optDouble( "calificacion" ), TipoUsuario.values() [ response.optInt( "tipo_usuario" ) ] );
                            LoginSession.getInstance().setUsuario( temp );
                        } else {
                            Toast.makeText( currentContext, R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse( VolleyError error ) {
                        Toast.makeText( currentContext, R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                    }
                } ) {
                    @Override
                    public Map< String, String > getHeaders() throws AuthFailureError {
                        HashMap< String, String > headers = new HashMap< String, String > ();
                        headers.put( "Authorization", "Bearer " + accessToken );
                        return headers;
                    }
                };
                request.add( objectRequest );
            } catch( Exception exception ) { exception.printStackTrace(); }
        }
    }
 */
    public void login( final Activity currentActivity, final String usuario, final String contrasena ) {
        RequestQueue request = Volley.newRequestQueue( currentActivity.getBaseContext() );
        try {
            JSONObject payload = objetos.crearObjetoJson( usuario, contrasena );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.POST, loginURL, payload, new Response.Listener< JSONObject >() {
                @Override
                public void onResponse( JSONObject response ) {
                    if( response != null ) {
                        LoginSession.getInstance().login( response.optInt( "clave_usuario" ), response.optString( "access_token" ) );
                        ( ( MainActivity )currentActivity ).setUserMenu();
                        Toast.makeText( currentActivity.getBaseContext(), R.string.login_exitoso, Toast.LENGTH_SHORT ).show();
                        getUsuario( currentActivity.getBaseContext(), LoginSession.getInstance().getClaveUsuario(), LoginSession.getInstance().getAccessToken() );
                    } else {
                        Toast.makeText( currentActivity.getBaseContext(), R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentActivity.getBaseContext(), R.string.login_fracaso, Toast.LENGTH_SHORT ).show();
                }
            } );
            request.add( objectRequest );
        } catch( org.json.JSONException json ) {
            json.printStackTrace();
        }
    }

    public void registrarUsuario( final Context currentContext, final Usuario usuario ) {
        RequestQueue request = Volley.newRequestQueue( currentContext );
        try {
            JSONObject payload = objetos.crearObjectoJson( usuario );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.POST, usuariosURL, payload, new Response.Listener< JSONObject >() {
                @Override
                public void onResponse( JSONObject response ) {
                    Toast.makeText( currentContext, R.string.usuario_creado_exito, Toast.LENGTH_SHORT ).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentContext, R.string.usuario_ya_existe, Toast.LENGTH_SHORT ).show();
                }
            } );
            request.add( objectRequest );
        } catch( org.json.JSONException json ) {
            json.printStackTrace();
        }
    }

    public void getUsuario( final Context currentContext, final int claveUsuario, final String accessToken ) {
        RequestQueue request = Volley.newRequestQueue( currentContext );
        try {
            String requestURL = usuarioEspecificoURL + claveUsuario;
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.GET, requestURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse( JSONObject response ) {
                    if( response != null ) {
                        Usuario temp = new Usuario( response.optInt( "clave_usuario" ), response.optString( "nombres" ), response.optString( "apellidos" ),
                                response.optString( "correo_electronico" ), response.optString("telefono" ), response.optString( "nombre_usuario" ),
                                response.optString( "contrasena" ), ( float )response.optDouble( "calificacion" ), TipoUsuario.values() [ response.optInt( "tipo_usuario" ) ] );
                        LoginSession.getInstance().setUsuario( temp );
                    } else {
                        Toast.makeText( currentContext, R.string.usuario_no_encontrado, Toast.LENGTH_SHORT ).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentContext, R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                }
            } ) {
                @Override
                public Map< String, String > getHeaders() throws AuthFailureError {
                    HashMap< String, String > headers = new HashMap< String, String > ();
                    headers.put( "Authorization", "Bearer " + accessToken );
                    return headers;
                }
            };
            request.add( objectRequest );
        } catch( Exception exception ) { exception.printStackTrace(); }
    }

    public void actualizarUsuario( final Context currentContext, final Usuario usuario, final String accessToken ) {
        RequestQueue request = Volley.newRequestQueue( currentContext );
        try {
            String requestURL = usuarioEspecificoURL + usuario.getClaveUsuario();
            JSONObject payload = objetos.crearObjectoJson( usuario );
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.PUT, requestURL, payload, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse( JSONObject response ) {
                    Toast.makeText( currentContext, R.string.actualizacion_exitosa, Toast.LENGTH_SHORT ).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentContext, R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                }
            } ) {
                @Override
                public Map< String, String > getHeaders() throws AuthFailureError {
                    HashMap< String, String > headers = new HashMap< String, String > ();
                    headers.put( "Authorization", "Bearer " + accessToken );
                    return headers;
                }
            };
            request.add( objectRequest );
        } catch( Exception exception ) { exception.printStackTrace(); }
    }

    public void eliminarUsuario( final Activity currentActivity, final int claveUsuario, final String accessToken ) {
        RequestQueue request = Volley.newRequestQueue( currentActivity.getBaseContext() );
        try {
            String requestURL = usuarioEspecificoURL + claveUsuario;
            JsonObjectRequest objectRequest = new JsonObjectRequest( Request.Method.DELETE, requestURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse( JSONObject response ) {
                    LoginSession.getInstance().logout();
                    ( ( MainActivity )currentActivity ).setNonUserMenu();
                    Toast.makeText( currentActivity.getBaseContext(), R.string.eliminacion_exitosa, Toast.LENGTH_SHORT ).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse( VolleyError error ) {
                    Toast.makeText( currentActivity.getBaseContext(), R.string.clave_usuario_no_encontrada, Toast.LENGTH_SHORT ).show();
                }
            } ) {
                @Override
                public Map< String, String > getHeaders() throws AuthFailureError {
                    HashMap< String, String > headers = new HashMap< String, String > ();
                    headers.put( "Authorization", "Bearer " + accessToken );
                    return headers;
                }
            };
            request.add( objectRequest );
        } catch( Exception exception ) { exception.printStackTrace(); }
    }

    public void getPublicacionesBuscar( final Activity currentActivity ) {
        RequestQueue request = Volley.newRequestQueue( currentActivity.getBaseContext() );
        JsonArrayRequest arrayRequest = new JsonArrayRequest( Request.Method.GET, publicacionesURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse( JSONArray response ) {
                List< Publicacion > publicaciones = new ArrayList<>();
                for( int currentObject = 0; currentObject < response.length(); currentObject++ ) {
                    try {
                        JSONObject object = response.getJSONObject( currentObject );
                        publicaciones.add( new Publicacion( object.getInt( "clave_publicacion" ), object.getString( "nombre" ), object.getString( "descripcion" ),
                                Categoria.values()[ object.getInt( "categoria" ) ], object.getDouble( "precio" ), object.getInt( "cantidad_disponible" ),
                                object.getDouble( "calificacion_general" ), object.getString( "unidad_medida" ), object.getInt( "numero_ventas" ),
                                object.getString( "imagen") ) );
                    } catch( org.json.JSONException json ) {
                        json.printStackTrace();
                    }
                }
                ( ( BuscarActivity ) currentActivity ).setPublicaciones( publicaciones );
            }}, new Response.ErrorListener() {
            @Override
            public void onErrorResponse( VolleyError error ) {
                Toast.makeText( currentActivity.getBaseContext(), R.string.publicaciones_no_encontradas, Toast.LENGTH_SHORT ).show();
            }
        } );
        request.add( arrayRequest );
    }
}
