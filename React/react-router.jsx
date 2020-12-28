// npm install react-router-dom

import React, { Component } from 'react';
import { StaticRouter, generatePath, matchPath, withRouter } from 'react-router';
import {
  BrowserRouter,
  HashRouter,
  MemoryRouter,
  Router,
  Route,
  Link,
  NavLink,
  Redirect,
  Switch,
} from 'react-router-dom';

/**
 * basename: string, app served the sub-directory
 * getUserConfirmation: function, A function to use to confirm navigation. Defaults to using window.confirm
 * forceRefresh: bool, full page refreshes on page navigation
 * keyLength: number, The length of locations.key Defaults to 6
 * children: node, The child elements to render
 */
<BrowserRouter
  basename='/app'
  getUserConfirmation={(message, callback) => {
    const allowTransition = window.confirm(message);
    callback(allowTransition);
  }}
  forceRefresh={true}
  keyLength={12}
>
  <Link to='/home' /> // renders <a href='/app/home'></a>
</BrowserRouter>;
/**
 * Hash history does not support location.key or location.state
 * basename: string, The base URL for all locations
 * getUserConfirmation: function, A function to use to confirm navigation. Defaults to using window.confirm
 * hashType: string, The type of encoding to use for window.location.hash
 *  1. slash - Creates hashes like #/ and #/app/home. Defaults
 *  2. noslash - Creates hashes like # and #app/home
 *  3. hashbang - Creates hashes like #!/ and #!/app/home
 * children: node, The single child element to render
 */
<HashRouter
  basename='/app'
  getUserConfirmation={(message, callback) => {
    // this is the default behavior
    const allowTransition = window.confirm(message);
    callback(allowTransition);
  }}
  hashType={'slash'}
>
  <Link to='/home' /> // renders <a href='#/app/home'></a>
</HashRouter>;
/**
 * Useful in tests and non-browser environments like React Native
 * initialEntries: array, An array of locations in the history stack, location objects with { pathname, search, hash, state } or simple string URLs
 * initialIndex: number, The initial location's index in the array of initialEntries
 * getUserConfirmation: function,
 * keyLength: number, The length of location.key. Default to 6
 * children: node, The child elements to render
 */
<MemoryRouter
  initialEntries={['/one', '/two', { pathname: '/three' }]}
  initialIndex={1}
  getUserConfirmation={(message, callback) => {
    const allowTransition = window.confirm(message);
    callback(allowTransition);
  }}
  keyLength={12}
>
  <App />
</MemoryRouter>;
/**
 * server-side rendering
 * basename: string,
 * location: string,
 *           object, { pathname, search, hash, state }
 * context: object, A plain JavaScript object. Components can add properties to the object to store information about the render.
 * children: node, A child element to render
 */
<StaticRouter basename='/app' location={req.url} context={{ name: 'hello world', age: 18 }}>
  <Link to='/home' /> // renders <a href='/app/home'></a>
</StaticRouter>;
/**
 * to: string, A string representation of the Link location
 *     object, { pathname, search, hash, state }
 *     function, A function to which current location is passed as an argument
 * replace: bool, Clicking the link will replace the current entry in the history stack instead of adding a new one
 * innerRef: function, underlying ref of the component
 *           RefObject,
 * component: React.Component,
 * others, pass props
 */
<Link
  to={{
    pathname: '/courses',
    search: '?sort=name',
    hash: '#the-hash',
    state: { fromDashboard: true },
  }}
  replace
  innerRef={(node) => {
    // `node` refers to the mounted DOM element
    // or null when unmounted
  }}
></Link>;
/**
 * A special version of the <Link /> that will add styling attrs to rendered element
 * activeClassName: string, active element className, default active
 * activeStyle: object, active element style
 * exact: bool, class/style will only be applied if the location is matched exactly
 * strict: bool, the trailing slash on a location’s pathname
 * isActive: function, Add extra logic for determining whether the link is active
 * location: object, { pathname, search, hash, state }
 * aria-current: string, default page
 *    page, step, location, date, time, true, false
 */
<NavLink
  to='/home'
  activeClassName='active'
  activeStyle={{
    fontWeight: 'bold',
    color: 'red',
  }}
  exact
  strict
></NavLink>;
/**
 * to: string,
 *     object, { pathname, search, hash, state }
 * push: bool, Redirecting will push a new entry onto the history stack
 * from: string, A pathname to redirect from. Rendering <Redirect /> inside of <Switch />
 * exact: bool, Match from exactly; equivalent to Route.exact. Rendering <Redirect /> inside of <Switch />
 * strict: bool, Match from strictly; equivalent to Route.strict. Rendering <Redirect /> inside of <Switch />
 * sensitive: bool, Match from case sensitive; equivalent to Route.sensitive.
 */
<Redirect
  to={{
    pathname: '/login',
    search: '?utm=your+face',
    state: { referrer: currentLocation },
  }}
  push
  from='/old-path'
  exact
  strict
  sensitive
></Redirect>;
/**
 * Re-exported from core Prompt
 */
<Prompt />;
/**
 * Render some UI when its path matches the current URL
 * Route Render Methods:
 *  component, <Route component> takes precedence(优先权) over <Route render> so don’t use both in the same <Route>.
 *  render,
 *  children, <Route children> takes precedence(优先权) over both <Route component> and <Route render> so don’t use more than one in the same <Route>.
 * path: string | string[], Any valid URL path or array of paths
 * exact: bool,
 * strict: bool,
 * location: object, { pathname, search, hash, state }
 * sensitive: bool,
 * sensitive: bool,
 */
<Route
  path={['/users/:id', '/profile/:id']}
  component={User}
  render={() => <div>Home</div>}
  children={({ match }) => (
    <li className={match ? 'active' : ''}>
      <Link to={to} {...rest} />
    </li>
  )}
></Route>;
/**
 * The common low-level interface for all router components. Typically apps will use one of the high-level routers instead:
 * <BrowserRouter>
 * <HashRouter>
 * <MemoryRouter>
 * <NativeRouter>
 * <StaticRouter>
 * history: object, A history object to use for navigation.
 * children: node, A child element to render
 */
<Router history={createBrowserHistory()}></Router>;
/**
 * location: object, { pathname, search, hash, state }
 * children: node, Only the first child to match the current location
 */
<Switch></Switch>;
/**
 * generate URLs to the routes.
 * pattern: string, The first one is a pattern provided as a path attribute to the Route component.
 * params: object, The second argument is an object with corresponding params for the pattern to use.
 */
const result = generatePath('/user/:id/:entity(posts|comments)', {
  id: 1,
  entity: 'posts',
}); // Will return /user/1/posts
/**
 * pathname: string, If you’re using this on the server with Node.js, it would be req.path.
 * props: Object, { path, strict, exact }
 * returns
 *  It returns an object when provided pathname does match path prop.
 *  It returns null when provided pathname does not match path prop.
 */
matchPath('/users/2', {
  path: '/users/:id',
  exact: true,
  strict: true,
});
//  {
//    isExact: true
//    params: {
//        id: "2"
//    }
//    path: "/users/:id"
//    url: "/users/2"
//  }
/**
 * It will pass updated match, location, and history props to the wrapped component whenever it renders.
 */
withRouter();
