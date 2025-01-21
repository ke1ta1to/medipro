import { Metadata } from "next";
import { PropsWithChildren } from "react";
import { BaseLayout } from "@/components/base-layout";

import "./globals.css";

export const metadata: Metadata = {
  title: "メディプロ",
  description: "メディア情報学",
};

export default function RootLayout({ children }: PropsWithChildren) {
  return (
    <html lang="ja">
      <body>
        <BaseLayout>{children}</BaseLayout>
      </body>
    </html>
  );
}
