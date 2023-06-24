package constants;

public enum Endpoint {

    LIST_USERS("https://reqres.in/api/users?page=2"),
    SINGLE_USER("https://reqres.in/api/users/2"),
    SINGLE_USER_NOT_FOUND("https://reqres.in/api/users/23"),
    LIST_RESOURCE("https://reqres.in/api/unknown"),
    SINGLE_RESOURCE("https://reqres.in/api/unknown/2"),
    SINGLE_RESOURCE_NOT_FOUND("https://reqres.in/api/unknown/23"),
    CREATE("https://reqres.in/api/users"),
    UPDATE_PUT("https://reqres.in/api/users/2"),
    UPDATE_PATCH("https://reqres.in/api/users/3"),
    DELETE("https://reqres.in/api/users/4"),
    REGISTER_SUCCESSFUL("https://reqres.in/api/register"),
    REGISTER_UNSUCCESSFUL("https://reqres.in/api/register"),
    LOGIN_SUCCESSFUL("https://reqres.in/api/login"),
    LOGIN_UNSUCCESSFUL("https://reqres.in/api/login"),
    DELAYED_RESPONSE("https://reqres.in/api/users?delay=3");

    private final String endpoint;

    Endpoint(String endpoint){
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
