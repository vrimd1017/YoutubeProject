package Parts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeScopes;
import com.google.gson.Gson;

import domain.Token;
import domain.VO.PlaylistVO;
import domain.VO.SimplePlaylistVO;
import Parts.MakeHttpConnection;
public class OAuth_Path {
	//private static final String APPLICATION_NAME = "youtube-study-helper";
    //private static final File DATA_STORE_DIR = new File(System.getProperty("user.home"), ".oauth-credentials");
    //private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    //private static final List<String> SCOPES = Arrays.asList(YouTubeScopes.YOUTUBE_FORCE_SSL);
    
    //private static FileDataStoreFactory DATA_STORE_FACTORY;
    
    private static final String client_id ="544959004631-rcuitmelmdk664g3cpoquak91b51j92e.apps.googleusercontent.com"; 
    private static final String client_secret = "gopS88e4NEXxiZ3SoyZ-qUAB";
    private static final String redirect_uri = "http://localhost:8080/myapp/Auth"; 
  //나중에 redirect_uri손봐야함.
    private static final String grant_type = "authorization_code";
    
    
    private YoutubeFunc youtubeFunc = new YoutubeFunc();
    public Token getToken(String code){
    	MakeHttpConnection makeHttpConnection = new MakeHttpConnection();
    	String tokenJson="";  
    	String query = "code="+code;
    	query += "&client_id=" + client_id;
    	query += "&client_secret=" + client_secret;
    	query += "&redirect_uri=" + redirect_uri;
    	query += "&grant_type="+grant_type;
    	try {
    	tokenJson = makeHttpConnection.getHttpConnection("https://accounts.google.com/o/oauth2/token", query);
    	//System.out.println(tokenJson);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	Gson gson = new Gson();
    	Token token = gson.fromJson(tokenJson,  Token.class);
    	
    	//System.out.println("access : "+token.getAccess_token());
    
    	//List<SimplePlaylistVO> list = youtubeFunc.getPlaylist(token.getAccess_token());
    	//List<PlaylistVO> details = youtubeFunc.getPlaylistItems(list.get(0).getId());
    	//String duration = youtubeFunc.getVideoDuration(details.get(0).getVideoId());
    	//System.out.println(list.get(0).getTitle());
    //	System.out.println(details.get(0).getDescription());
    	//System.out.println(list.get(0).getId());
    	//System.out.println(details.get(0).getVideoId());
    	//System.out.println(duration);
    	//콘솔 결과 확인용.
    	return token;
    }
        
   
}
