import {Injectable} from "@angular/core";
import {
  HttpEvent,
  HttpHandler,
  HttpInterceptor, HttpRequest
} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    req = req.clone({withCredentials: true});
    req.headers.set('X-Requested-With', 'XMLHttpRequest');
    return next.handle(req);
  }
}
