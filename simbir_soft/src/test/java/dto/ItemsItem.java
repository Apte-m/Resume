package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsItem{

	@JsonProperty("preview")
	private String preview;

	@JsonProperty("sha256")
	private String sha256;

	@JsonProperty("created")
	private String created;

	@JsonProperty("type")
	private String type;

	@JsonProperty("antivirus_status")
	private String antivirusStatus;

	@JsonProperty("revision")
	private long revision;

	@JsonProperty("path")
	private String path;

	@JsonProperty("file")
	private String file;

	@JsonProperty("size")
	private int size;

	@JsonProperty("mime_type")
	private String mimeType;

	@JsonProperty("media_type")
	private String mediaType;

	@JsonProperty("name")
	private String name;

	@JsonProperty("resource_id")
	private String resourceId;

	@JsonProperty("modified")
	private String modified;

	@JsonProperty("comment_ids")
	private CommentIds commentIds;

	@JsonProperty("exif")
	private Exif exif;

	@JsonProperty("md5")
	private String md5;


}