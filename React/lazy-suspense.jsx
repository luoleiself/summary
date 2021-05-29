import React, { Suspense } from 'react';

/**
 * React.lazy 目前只支持默认导出（default exports）.
 * fallback 属性接受任何再组件加载过程中想要展示的 React 元素.
 */
const OtherComponent = React.lazy(() => import('./OtherComponent'));
const AnotherComponent = React.lazy(() => import('./AnotherComponent'));

function MyComponent() {
  return (
    <div>
      <Suspense fallback={<div>Loading...</div>}>
        <section>
          <OtherComponent />
          <AnotherComponent />
        </section>
      </Suspense>
    </div>
  );
}
