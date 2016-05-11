package supportlibraries;

public enum TestEnvironment {

	//Android("android"),
		Preprod("preprod"),
		Test("test");
		
		private String value;
		
		TestEnvironment(String value)
		{
			this.value = value;
		}
		
		public String getValue()
		{
			return value;
		}
		
		/*@Override
		public String toString()
		{
			return value;
		}*/
	}

