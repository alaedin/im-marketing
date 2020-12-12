import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class PersonService {

	public uri = environment.proxyUrl + environment.imMarketing + '/im-workspace/person';

	constructor(private http: HttpClient) {
	}


	getAll(): Observable<any> {
		return this.http.get(this.uri);
	}

	create(data): Observable<any> {
		return this.http.post(this.uri + '/add', data);
	}

	update(id, data): Observable<any> {
		return this.http.put(this.uri + '/update', data);
	}

	delete(id): Observable<any> {
		return this.http.delete(this.uri + '/delete/' + id);
	}

	deleteAll(): Observable<any> {
		return this.http.delete(this.uri);
	}

	getByOne(id): Observable<any> {
		return this.http.get<any>(this.uri + '/' + id);
	}

	getByRole(commercialId): Observable<any> {
		return this.http.get(this.uri + '/roleId/' + commercialId);

	}
}
