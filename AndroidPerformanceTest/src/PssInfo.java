public class PssInfo {

	private static float getTotalPSSInfo(String sn, String PSSInfo) {
		float pss = 0;

		try {
			String data[] = PSSInfo.split("\\s+");
			pss = Float.parseFloat(data[2]);
		} catch (Exception ex) {
			pss = 0;
		}
		return pss;

	}

	public static float getPssData(String sn, String packageName) {
		String TOP_PSSINFO = ""
				+ sn + " shell dumpsys meminfo " + packageName + "|grep TOTAL";
		String pssInfo = ADBShell.sendADB(TOP_PSSINFO, 5000);

		float pssData = getTotalPSSInfo(sn, pssInfo);
		return pssData;
	}
}
