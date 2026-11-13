import { Routes } from '@angular/router';
import { authGuard } from './core/auth-guard';
import { permisoGuard } from './core/permiso-guard';

export const routes: Routes = [

    {
        path: 'login',
        title: 'Iniciar sesión · Llave',
        loadComponent: () => import('./pages/login/login').then(m => m.Login)
      }
      
   
];
