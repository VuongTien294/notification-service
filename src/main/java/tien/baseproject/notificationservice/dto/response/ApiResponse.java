package tien.baseproject.notificationservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Collections;

@Getter
@Setter
@Accessors(fluent = true, chain = true)
public class ApiResponse<T> {

	//TODO : Nhớ tìm hiểu cái @Accessors

	@JsonProperty("status")
	private String status;

	@JsonProperty("code")
	private Integer code;

	@JsonProperty("data")
	private T data;

	public ApiResponse(T data) {
		this.data = data;
	}

	public static ApiResponse<?> success() {
		return new ApiResponse<>(Collections.emptyMap())
						.status("SUCCESS")
						.code(ApiResponseCode.SUCCESSFULLY);
	}
}
