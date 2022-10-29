package dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class File{

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("items")
	private List<ItemsItem> items;




}