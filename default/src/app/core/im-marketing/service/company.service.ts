import {Injectable} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
	providedIn: 'root'
})
export class CompanyService {


	public uri = environment.proxyUrl + environment.imMarketing + '/im-workspace/company';

	constructor(private http: HttpClient) {
	}


	getAll(): Observable<any> {
		return this.http.get(this.uri);
	}

	create(data): Observable<any> {
		return this.http.post(this.uri, data);
	}

	update(id, data): Observable<any> {
		return this.http.put(this.uri + '/update', data);
	}

	delete(id): Observable<any> {
		return this.http.delete(this.uri + '/' + id);
	}

	deleteAll(): Observable<any> {
		return this.http.delete(this.uri);
	}

	getByOne(id): Observable<any> {
		return this.http.get<any>(this.uri + '/' + id);
	}
}
