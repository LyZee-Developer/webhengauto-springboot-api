package api.hgseviceweb.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseHandler {
    private Boolean Status = false;
    private String Message ="";
    private Object Detail="";
    private String StatusCode="";
    private Boolean IsSuccess=false;
    public  ApiResponseHandler SetDetail(Object detail){
        this.Detail = detail;
        return this;
    }
    public  ApiResponseHandler SetDetail(String Message){
        this.Message = Message;
        return this;
    }
    
    public  ApiResponseHandler SetSuccess(String message){
        this.Status = true;
        this.IsSuccess = true;
        this.Message = (message == null) ? "Processing Success" : message;
        return this;
    }
    public  ResponseEntity<?> SetDetail(String message,HttpStatus status){
        this.Message = message;
        return new ResponseEntity<>(this,status);
    }
    public  ResponseEntity<?> SetDetail(ApiResponseHandler message,HttpStatus status){
        return new ResponseEntity<>(message,status);
    }
}
