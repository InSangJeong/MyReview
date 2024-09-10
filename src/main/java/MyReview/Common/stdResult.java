package MyReview.Common;

public class stdResult {
    private int code;
    private String message;
    private String jsonObject;

    public stdResult(int code, String message, String jsonObject) {
        this.code = code;
        this.message = message;
        this.jsonObject = jsonObject;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getJsonObject() {
        return jsonObject;

    }
    public static stdResult Success(){
        return new stdResult(0, "OK", null);
    }
    public static stdResult NotSupport(){
        return new stdResult(-99, "Not Support", null);
    }
    public static stdResult Unauthorized(){
        return new stdResult(401, "Unauthorized", "You don't have permission.");
    }

}
