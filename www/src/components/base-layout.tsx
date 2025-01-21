import { PropsWithChildren } from "react";

import { Header } from "./header";

export function BaseLayout({ children }: PropsWithChildren) {
  return (
    <>
      <Header />
      <div className="mx-auto min-h-screen max-w-6xl bg-white px-2">
        {children}
      </div>
    </>
  );
}
