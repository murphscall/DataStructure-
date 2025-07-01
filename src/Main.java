import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import eventHistory.Action;
import eventHistory.EventHistory;
import eventHistory.ScreenType;
import eventHistory.UserType;

public class Main {
  public static void main(String[] args) throws IOException {
    EventHistory eventHistory = new EventHistory(1L,null, UserType.AnonymousUser, LocalDateTime.now(), ScreenType.LOGIN_PAGE, Action.VIEW, null , "gg" );

    System.out.println(eventHistory);
  }
}
