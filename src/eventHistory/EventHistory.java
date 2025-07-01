package eventHistory;

import java.time.LocalDateTime;

public class EventHistory {
	private Long id;
	private String userId;
	private UserType userType;
	private LocalDateTime timestamp;
	private ScreenType screenType;
	private Action action;
	private ScreenType fromScreen;
	private String detail;

	public EventHistory(){};

	public EventHistory(Long id, String userId, UserType userType, LocalDateTime timestamp, ScreenType screenType, Action action,
		ScreenType fromScreen, String detail) {
		this.id = id;
		this.userId = userId;
		this.userType = userType;
		this.timestamp = timestamp;
		this.screenType = screenType;
		this.action = action;
		this.fromScreen = fromScreen;
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "EventHistory{" +
			"id=" + id +
			", userId='" + userId + '\'' +
			", userType=" + userType +
			", timestamp=" + timestamp +
			", screenType=" + screenType +
			", action=" + action +
			", fromScreen=" + fromScreen +
			", detail='" + detail + '\'' +
			'}';
	}
}
