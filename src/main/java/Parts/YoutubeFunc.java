package Parts;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import domain.Object.PlaylistObject;
import domain.Object.PlaylistObjects;
import domain.Object.VideoResponseObject;
import domain.VO.PlaylistVO;
import domain.VO.SimplePlaylistVO;

public class YoutubeFunc {
	// private static HttpTransport HTTP_TRANSPORT;
	// private static final JsonFactory JSON_FACTORY =
	// JacksonFactory.getDefaultInstance();
	private MakeHttpConnection makeHttpConnection = new MakeHttpConnection();
	private Gson gson = new Gson();
	private final String API_KEY = "AIzaSyCM4nZEsnIEHAVIF8PpFzsbnx62fu8socw";
	/*
	public String getVideoDuration(String videoId) {
		String Json = "";
		String query = "part=contentDetails&id=" + videoId + "&key="+API_KEY;
	
		try {
			// System.out.println(playlistJson2);
			Json = makeHttpConnection
					.getHttpConnectionGet("https://www.googleapis.com/youtube/v3/videos", query);
		} catch (Exception e) {
			e.printStackTrace();
		}

		VideoResponseObject obj = gson.fromJson(Json, VideoResponseObject.class);
		return obj.getItmes().get(0).getContentDetails().getDuration();

	}
	*/
	
	public List<PlaylistVO> getPlaylistItems(String playlistId) {
		String playlistJson2 = "";
		String query = "part=snippet&maxResults=50&playlistId=" + playlistId + "&key="+API_KEY;
		List<PlaylistVO> playlistVO = new ArrayList<>();

		try {
			// System.out.println(playlistJson2);
			playlistJson2 = makeHttpConnection
					.getHttpConnectionGet("https://www.googleapis.com/youtube/v3/playlistItems", query);
		} catch (Exception e) {
			e.printStackTrace();
		}                  

		PlaylistObjects playlists2 = gson.fromJson(playlistJson2, PlaylistObjects.class);

		for (PlaylistObject obj : playlists2.getItems()) {
			// System.out.println("@@@@");
			// System.out.println("title: " + obj.getSnippet().getTitle());
			// System.out.println("description : " + obj.getSnippet().getDescription());
			// System.out.println("thumbnails : " +
			// obj.getSnippet().getThumbnails().getHight().getUrl());//0. default.
			// System.out.println("thumbnails : " +
			// obj.getSnippet().getThumbnails().getStandard().getUrl());//0. default.
			// System.out.println("@@@@");
			PlaylistVO vo = new PlaylistVO();
			vo.setTitle(obj.getSnippet().getTitle());
			//vo.setDescription(obj.getSnippet().getDescription());
			vo.setThumbnail(obj.getSnippet().getThumbnails().getBase().getUrl());// standard.
			vo.setVideoId(obj.getSnippet().getResourceId().getVideoId());
			//vo.setVideoTime(getVideoDuration(obj.getSnippet().getResourceId().getVideoId()));
			playlistVO.add(vo);
		}
		return playlistVO;
	}

	public List<SimplePlaylistVO> getPlaylist(String access_token) {

		String playlistJson = "";
		String query = "part=snippet&mine=true&maxResults=50&access_token=" + access_token;
		List<SimplePlaylistVO> simplePlaylistVO = new ArrayList<>();

		try {
			playlistJson = makeHttpConnection.getHttpConnectionGet("https://www.googleapis.com/youtube/v3/playlists",
					query);
			// System.out.println(playlistJson);
		} catch (Exception e) {
			e.printStackTrace();
		}

		PlaylistObjects playlists = gson.fromJson(playlistJson, PlaylistObjects.class);
		// List<String> arrTitle = new ArrayList<>();
		// List<String> arrId = new ArrayList<>();

		for (PlaylistObject obj : playlists.getItems()) {
			// System.out.println("====");
			// System.out.println("id : " + obj.getId());
			// System.out.println("channelId : " + obj.getSnippet().getChannelId());
			// System.out.println("title : " + obj.getSnippet().getTitle());

			SimplePlaylistVO vo = new SimplePlaylistVO();
			vo.setId(obj.getId());
			vo.setTitle(obj.getSnippet().getTitle());
			simplePlaylistVO.add(vo);

			// arrTitle.add(obj.getSnippet().getTitle());
			// arrId.add(obj.getId());

			// System.out.println("====");
		}
		
		// System.out.println("오류떳나?");
		// System.out.println(playlists);
		return simplePlaylistVO;
	}

}
