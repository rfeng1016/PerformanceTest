public class TrafficInfo {

	private static String getTotalTrafficInfo(String sn, String trafficInfo) {
		String traffic = null;
		int start = 0;
		String[] character = null;

		try {

			int index = trafficInfo.lastIndexOf("\n");
			if (index >= 0) {
				String line = trafficInfo.substring(0, index);

				index = line.lastIndexOf("\n");
				line = trafficInfo.substring(index + 2, line.length());
				character = line.split("\\s+");
				traffic = character[1];
			}
		} catch (Exception ex) {
			traffic = "1";
		}
		return traffic;

	}

	public static String getTrafficData(String sn, String packageName) {
		String TRAFFIC_INFO = ""
				+ sn + " logcat | grep " + packageName + "Traffic";
		String trafficInfo = ADBShell.sendADB(TRAFFIC_INFO, 5000);

		String TrafficData = getTotalTrafficInfo(sn, trafficInfo);
		return TrafficData;
	}
}
