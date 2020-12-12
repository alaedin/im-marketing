export class Role {
	id: number;
	roleName: string;

	clean() {
		this.roleName = '';
	}
}
