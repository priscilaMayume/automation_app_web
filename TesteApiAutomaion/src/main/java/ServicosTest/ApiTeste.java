package ServicosTest;

import constants.Endpoint;
import constants.Log;
import constants.Request;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

public class ApiTeste {

    @Test
    public void listarUsuarioComSucesso() {
        Log.info("Iniciar método: listarUsuarioComSucesso");

        Response response = Request.doGetRequest(Endpoint.LIST_USERS);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("data"));

        Log.info("Finalizar método: listarUsuarioComSucesso");

    }

    @Test
    public void verificarUsuarioId2ComSucesso() {
        Log.info("Iniciar método: verificarUsuarioId2ComSucesso");

        Response response = Request.doGetRequest(Endpoint.SINGLE_USER);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("data"));
        Assert.assertEquals(new Integer(2), response.path("data.id"));
        Assert.assertEquals("Janet", response.path("data.first_name"));

        Log.info("Finalizar método: verificarUsuarioId2ComSucesso");

    }

    @Test
    public void verificarUsuarioInexistente() {
        Log.info("Iniciar método: verificarUsuarioInexistente");

        Response response = Request.doGetRequest(Endpoint.SINGLE_USER_NOT_FOUND);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertNull(response.getBody().jsonPath().getJsonObject("data"));

        Log.info("Finalizar método: verificarUsuarioInexistente");
    }

    @Test
    public void verificarListaCompletaComSucesso() {
        Log.info("Iniciar método: verificarListaCompletaComSucesso");

        Response response = Request.doGetRequest(Endpoint.LIST_RESOURCE);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("data"));
        Assert.assertTrue(response.getBody().jsonPath().getList("data.name").
                contains("true red"));

        Log.info("Finalizar método: verificarListaCompletaComSucesso");
    }

    @Test
    public void verificarUsuarioId3DaListaComSucesso() {
        Log.info("Iniciar método: verificarUsuarioId3DaListaComSucesso");

        Response response = Request.doGetRequest(Endpoint.SINGLE_RESOURCE);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("data"));
        Assert.assertEquals("fuchsia rose", response.getBody().jsonPath().getJsonObject("data.name"));

        Log.info("Finalizar método: verificarUsuarioId3DaListaComSucesso");
    }

    @Test
    public void verificarRecursoNaoEncontrado() {
        Log.info("Iniciar método: verificarRecursoNaoEncontrado");

        Response response = Request.doGetRequest(Endpoint.SINGLE_RESOURCE_NOT_FOUND);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
        Assert.assertNull(response.getBody().jsonPath().getJsonObject("data"));

        Log.info("Finalizar método: verificarRecursoNaoEncontrado");
    }

    @Test
    public void criarNovoUsuarioComSucesso() {
        Log.info("Iniciar método: criarNovoUsuarioComSucesso");

        String body;
        body = ("{\"name\": \"Luan\", \"job\": \"Front\"}");

        Response response = Request.doPostRequest(body, Endpoint.CREATE);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("name"));
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("job"));
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("id"));
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("createdAt"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: criarNovoUsuarioComSucesso");
    }

    @Test
    public void AlterarUsuarioComSucessoPUT() {
        Log.info("Iniciar método: AlterarUsuarioComSucesso");

        String body;
        body = ("{\"name\": \"Amanda\", \"job\": \"Analista\"}");

        Response response = Request.doPutRequest(body, Endpoint.UPDATE_PUT);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("updatedAt"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: AlterarUsuarioComSucesso");
    }

    @Test
    public void AlterarUsuarioComSucessoPATCH() {
        Log.info("Iniciar método: AlterarUsuarioComSucessoPATCH");

        String body;
        body = ("{\"name\": \"Luciana\", \"job\": \"Analista\"}");

        Response response = Request.doPatchRequest(body, Endpoint.UPDATE_PATCH);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("updatedAt"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: AlterarUsuarioComSucessoPATCH");
    }

    @Test
    public void deletarUsuarioComSucesso() {
        Log.info("Iniciar método: deletarUsuarioComSucesso");

        Response response = Request.doDeleteRequest(Endpoint.DELETE);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NO_CONTENT);

        Log.info("Finalizar método: deletarUsuarioComSucesso");

    }

    @Test
    public void registrarComSucesso() {
        Log.info("Iniciar método: registrarComSucesso");

        String body;
        body = ("{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}");

        Response response = Request.doPostRequest(body, Endpoint.REGISTER_SUCCESSFUL);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("id"));
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("token"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: registrarComSucesso");

    }

    @Test
    public void verificarRegistroInexistente() {
        Log.info("Iniciar método: verificarRegistroInexistente");

        String body;
        body = ("{\"email\": \"sydney@fife\"}");

        Response response = Request.doPostRequest(body, Endpoint.REGISTER_UNSUCCESSFUL);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getBody().jsonPath().getString("error").contains("Missing password"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: verificarRegistroInexistente");

    }

    @Test
    public void registrarLoginComSucesso() {
        Log.info("Iniciar método: registrarLoginComSucesso");

        String body;
        body = ("{\"email\": \"eve.holt@reqres.in\", \"password\": \"cityslicka\"}");

        Response response = Request.doPostRequest(body, Endpoint.LOGIN_SUCCESSFUL);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        Assert.assertNotNull(response.getBody().jsonPath().getJsonObject("token"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: registrarLoginComSucesso");

    }

    @Test
    public void registrarLoginInexistente() {
        Log.info("Iniciar método: registrarLoginInexistente");

        String body;
        body = ("{\"email\": \"peter@klaven\"}");

        Response response = Request.doPostRequest(body, Endpoint.LOGIN_UNSUCCESSFUL);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
        Assert.assertTrue(response.getBody().jsonPath().getString("error").contains("Missing password"));

        response.getBody().prettyPrint();

        Log.info("Finalizar método: registrarLoginInexistente");

    }

    @Test
    public void delayExecutarComSucesso(){
        Log.info("Iniciar método: delayExecutarComSucesso");

        Response response = Request.doGetRequest(Endpoint.DELAYED_RESPONSE);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        Log.info("Finalizar método: delayExecutarComSucesso");

    }
}