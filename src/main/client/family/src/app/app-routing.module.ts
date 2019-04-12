import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FamilyComponent} from "./family/family.component";

const routes: Routes = [
  { path: '', redirectTo: '/family', pathMatch: 'full' },
  { path: 'family', component: FamilyComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
