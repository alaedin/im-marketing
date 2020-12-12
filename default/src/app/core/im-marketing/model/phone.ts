export class Phone {
	zone: number;
	phoneNumber: number;
	countryKey: number;

	clean() {
		this.zone = 0;
		this.phoneNumber = 0;
		this.countryKey = 0;
	}

}
