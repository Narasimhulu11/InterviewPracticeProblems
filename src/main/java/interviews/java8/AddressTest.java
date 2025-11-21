package interviews.java8;


public class AddressTest {
    class Address{
        private int numberR;
        private String street;
        private String town;
        private String district;
        private String State;
        private final String country="INDIA";
        private int pincode;

        public Address(int numberR, String street, String town, String district, String state, int pincode) {
            this.numberR = numberR;
            this.street = street;
            this.town = town;
            this.district = district;
            State = state;
            this.pincode = pincode;
        }

        @Override
        public boolean equals(Object o){
            if(this==o) return true;
            if(o==null) return false;
            if(!(o instanceof Address)){
                return false;
            }

            Address a=(Address) o;
            if(a.numberR==this.numberR && a.street.equals(this.street)){
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "numberR=" + numberR +
                    ", street='" + street + '\'' +
                    ", town='" + town + '\'' +
                    ", district='" + district + '\'' +
                    ", State='" + State + '\'' +
                    ", country='" + country + '\'' +
                    ", pincode=" + pincode +
                    '}';
        }
    }

    public static void main(String[] args) {
        Address address = new AddressTest().new Address(303,"Candeur sunshine","Kodigehalli","Bengaluru","Karnataka",560067);
        System.out.println(address.toString());
    }
}
