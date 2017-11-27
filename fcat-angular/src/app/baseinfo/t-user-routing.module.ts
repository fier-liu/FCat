import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {TUserListComponent} from "./t-user-list.component";
import {IndexComponent} from "../index/index.component";
import {TUserAddComponent} from "./t-user-add.component";
import {TUserUpdateComponent} from "./t-user-update.component";
import {TElementAddComponent} from "./t-element-add.component";
import {TElementUpdateComponent} from "./t-element-update.component";
import {TMenuUpdateComponent} from "./t-menu-update.component";
import {TMenuAddComponent} from "./t-menu-add.component";
import {TMenuListComponent} from "./t-menu-list.component";
import {TGroupTypeListComponent} from "./t-group-type-list.component";
import {TGroupTypeUpdateComponent} from "./t-group-type-update.component";
import {TGroupTypeAddComponent} from "./t-group-type-add.component";
import {TGroupListComponent} from "./t-group-list.component";
import {TGroupAddComponent} from "./t-group-add.component";
import {TGroupUpdateComponent} from "./t-group-update.component";
import {TGroupAddUserComponent} from "./t-group-add-user.component";
import {TGroupAuthorityComponent} from "./t-group-authority.component";


const routes: Routes = [
  {path: 'index',  component: IndexComponent,children: [
    {
      path: 'tUserList',
      component: TUserListComponent
    },
    {
      path: 'tUserAdd',
      component: TUserAddComponent
    },
    {
      path: 'tUserUpdate/:id',
      component: TUserUpdateComponent
    },
    {
      path: 'tElementAdd/:id',
      component: TElementAddComponent
    },
    {
      path: 'tElementUpdate/:id',
      component: TElementUpdateComponent
    },
    {
      path: 'tMenuList',
      component: TMenuListComponent
    },
    {
      path: 'tMenuAdd',
      component: TMenuAddComponent
    },
    {
      path: 'tMenuUpdate/:id',
      component: TMenuUpdateComponent
    },
    {
      path: 'tGroupTypeList',
      component: TGroupTypeListComponent
    },
    {
      path: 'tGroupTypeUpdate/:id',
      component: TGroupTypeUpdateComponent
    },
    {
      path: 'tGroupTypeAdd',
      component: TGroupTypeAddComponent
    },
    {
      path: 'tGroupList',
      component: TGroupListComponent
    },
    {
      path: 'tGroupAdd/:id',
      component: TGroupAddComponent
    },
    {
      path: 'tGroupUpdate/:id',
      component: TGroupUpdateComponent
    },
    {
      path: 'tGroupAddUser/:id',
      component: TGroupAddUserComponent
    },
    {
      path: 'tGroupAuthority/:id',
      component: TGroupAuthorityComponent
    },
    { path: '**',
      redirectTo: 'dashboard',
      pathMatch: 'full'
    }
  ]},
  { path: '**',
    redirectTo: '/index/dashboard',
    pathMatch: 'full'
  }
];
@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class TUserRoutingModule {}
