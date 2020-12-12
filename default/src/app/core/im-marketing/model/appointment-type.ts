export class AppointmentType {
	id: number;
	appointmentTypeName: string;

	clean() {
		this.appointmentTypeName = '';
	}
}
